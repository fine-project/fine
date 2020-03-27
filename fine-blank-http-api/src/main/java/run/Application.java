package run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = {
        "blank, com.fineframework.app, "
        + "com.fineframework.spring.web.config, "
        + "com.fineframework.spring.repository",
        "com.fineframework.spring.app",
        "com.fineframework.spring.auth.repository",
        "com.fineframework.auth.repository",
        "com.fineframework.auth.service",
        "com.fineframework.spring.auth.useridpassword",
 })
@Configuration
@ImportResource("root-context.xml")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
