package fine.spring.web.config;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
    import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import fine.spring.web.handler.AuthenticationInterceptor;
import fine.spring.web.handler.AuthorizationInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;
    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {

      // 認証
      registry.addInterceptor(authenticationInterceptor)
      .addPathPatterns("/**")
      .excludePathPatterns("/login")
      .excludePathPatterns("/error")
      .excludePathPatterns("/healthcheck")
      ;
    
      // 認可
      registry.addInterceptor(authorizationInterceptor)
      .addPathPatterns("/**")
      .excludePathPatterns("/login")
      .excludePathPatterns("/error")
      .excludePathPatterns("/healthcheck")
      ;
    
//        .excludePathPatterns("/**");
  }
}
