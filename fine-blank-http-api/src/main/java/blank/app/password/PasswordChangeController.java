package blank.app.password;


import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fineframework.auth.entity.UserSession;
import com.fineframework.net.http.FineStandardResponseBase;
import com.fineframework.net.http.FineStandardResponseError;
import com.fineframework.spring.web.handler.AuthenticationInterceptor;


@RestController
@CrossOrigin
public class PasswordChangeController {
	private static final Logger LOGGER = LogManager.getLogger(PasswordChangeController.class);
	
	@Autowired
	private PasswordChangeService passwordChangeService;

    @RequestMapping("/admin/users-password-change")
    public PasswordChangeResponse changePassword(
    		@RequestBody PasswordChangeRequest passwordChangeRequest, HttpServletRequest request) {

    	LOGGER.info("password change Start!");
    	
    	//User userInfo = (User) request.getSession(true).getAttribute("user");
    	UserSession userSession = AuthenticationInterceptor.getUserSession().get();
    	
    	String password = passwordChangeRequest.getPassword();
    	String confirmPassword = passwordChangeRequest.getConfirmPassword();
    	
		PasswordChangeResponse passwordChangeResponse = new PasswordChangeResponse();
		if (password.equals(confirmPassword)) {
			passwordChangeResponse = passwordChangeService.passwordChange(password, userSession);
		} else {
			passwordChangeResponse.setResult(FineStandardResponseBase.FAILED);
			FineStandardResponseError responseError = new FineStandardResponseError("LOGIN_ERROR", "新しいパスワードと確認のパスワードが一致しません");
			passwordChangeResponse.addError(responseError);
		}
		return passwordChangeResponse;
	}
}
