package com.fineframework.spring.web.handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fineframework.auth.entity.UserSession;
import com.fineframework.spring.repository.UsersSessionRepository;


@CrossOrigin
@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	private static final Logger LOGGER = LogManager.getLogger(AuthenticationInterceptor.class);
	public static final DateTimeFormatter formatterOfDateTime = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

	@Autowired
	private UsersSessionRepository usersSessionRepository;

	private static ThreadLocal<UserSession> threadLocalUserSession = new ThreadLocal<>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

//		if (request.getRequestURI().contains("/login") 
//		        || request.getRequestURI().contains("/error") 
//		        || request.getRequestURI().contains("/healthcheck")) {
//			return true;
//		}

		if ("options".equals(request.getMethod().toLowerCase())) {
			response.setStatus(200);
			return true;
		}

		String accessToken = request.getHeader("accessToken");
		UserSession userSession = new UserSession();
		userSession.setAccessToken(accessToken);
		UserSession session = usersSessionRepository.findByKey(userSession);

		if (ObjectUtils.isEmpty(session)) {
			threadLocalUserSession.set(new UserSession());
			LOGGER.info("access token failure. token was empty!");

			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Credentials", "true");
			response.setHeader("Access-Control-Allow-Methods",
					"ACL, CANCELUPLOAD, CHECKIN, CHECKOUT, COPY, DELETE, GET, HEAD, LOCK, MKCALENDAR, MKCOL, MOVE, OPTIONS, POST, PROPFIND, PROPPATCH, PUT, REPORT, SEARCH, UNCHECKOUT, UNLOCK, UPDATE, VERSION-CONTROL");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers",
					"Origin, X-Requested-With, Content-Type, Accept, Key, Authorization");
			response.setStatus(401);
			return false;
		} else {
			threadLocalUserSession.set(session);
			LocalDateTime updatedAt = LocalDateTime.parse(session.getUpdatedAt(), formatterOfDateTime);
			// 操作から1分以上経っている場合のみ、アクセストークンの時間を更新する
			LocalDateTime now = LocalDateTime.now();
			if (now.minusMinutes(3L).isAfter(updatedAt)) {
				LOGGER.info("3分以上経過したアクセストークンなので、update_atを更新します。");
				usersSessionRepository.updateUpdatedAt(session);
			}
			LOGGER.info("access token check success! userId=[" + session.getAccountId() + "]");
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	public static ThreadLocal<UserSession> getUserSession() {
		return threadLocalUserSession;
	}

}
