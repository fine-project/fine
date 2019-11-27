package fine.spring.task;

import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * アクセストークンを定期的に削除するオンラインバッチ。
 * TODO 現在実装中。
 * @author masanii15
 * @since 1.0
 */
@Component
@EnableScheduling
public class DeleteAccessTokenTask {
	
	private static final Logger LOGGER = LogManager.getLogger(DeleteAccessTokenTask.class);
    public static final DateTimeFormatter formatterOfDateTime = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

//	@Autowired
//	private UsersSessionRepository usersSessionRepository;
	
	@Scheduled(cron = "0 * * ? * *", zone = "Asia/Tokyo") 
    public void deleteAccessToken() {
		LOGGER.info("DeleteAccessTokenTask開始");
//        doDeleteAccessToken();
    }
	
//	private void doDeleteAccessToken() {
//		usersSessionRepository.deleteAccessToekn();
//	}

}
