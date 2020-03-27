package blank.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fineframework.spring.web.handler.AuthenticationInterceptor;
import com.fineframework.spring.web.handler.AuthorizationInterceptor;
import com.fineframework.spring.web.handler.CORSInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	private AuthenticationInterceptor authenticationInterceptor;
	@Autowired
	private AuthorizationInterceptor authorizationInterceptor;
	@Autowired
	private CORSInterceptor corsInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		// CORS
		registry.addInterceptor(corsInterceptor).addPathPatterns("/**");

		// 認証
		registry.addInterceptor(authenticationInterceptor)
			.addPathPatterns("/**")
			.excludePathPatterns("/account/login")
			.excludePathPatterns("/error")
			.excludePathPatterns("/healthcheck");

		// 認可
		registry.addInterceptor(authorizationInterceptor)
			.addPathPatterns("/**")
			.excludePathPatterns("/account/login")
			.excludePathPatterns("/error")
			.excludePathPatterns("/healthcheck");

	}
}
