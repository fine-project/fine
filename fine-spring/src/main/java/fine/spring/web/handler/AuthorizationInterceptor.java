package fine.spring.web.handler;

import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fine.auth.entity.UserSession;

@CrossOrigin
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

	private static final Logger LOGGER = LogManager.getLogger(AuthenticationInterceptor.class);
	public static final DateTimeFormatter formatterOfDateTime = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

	private static ThreadLocal<UserSession> threadLocalUserSession = new ThreadLocal<>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

//		if (request.getRequestURI().contains("/login") 
//		        || request.getRequestURI().contains("/error") 
//		        || request.getRequestURI().contains("/healthcheck")) {
//			return true;
//		}
				LOGGER.info("authorization");
		return true;
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
