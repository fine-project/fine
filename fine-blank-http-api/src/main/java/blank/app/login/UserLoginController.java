package blank.app.login;


import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fineframework.auth.entity.UserSession;
import com.fineframework.spring.repository.UsersSessionRepository;

import excel.ExcelReaderFactory;



@RestController
@CrossOrigin
@RequestMapping("/account")
public class UserLoginController {

    private static final Logger LOGGER = LogManager.getLogger(UserLoginController.class);

    @Autowired
    private UserLoginService loginService;
    @Autowired
    private UsersSessionRepository usersSessionRepository;
    @Autowired
    private ExcelReaderFactory excelReaderFactory;

   @RequestMapping("/login")
    public UserLoginResponse login(
            @RequestBody UserLoginRequest loginRequest, HttpServletRequest request) {
       
        
//
//          ExcelReader excelReader = excelReaderFactory.createReader();
//          excelReader.initialize("C:\\Users\\arche\\Desktop\\\\Book1.xlsx");
//          TestDto test = excelReader.getCellValue("0", TestDto.class);
//          System.out.println(test.getCellA());
//          System.out.println(test.getCellB());
//          System.out.println(test.getCellC());
//          for (InnerDto inner : test.getListMap()) {
//              System.out.println(inner.getHoge());
//              System.out.println(inner.getHoge2());
//              System.out.println(inner.getHoge3());
//          }
//
//          System.out.println("OK");
//
        LOGGER.info("execute login!");
        LOGGER.info("userId:" + loginRequest.getUserId());
        LOGGER.debug("password:" + loginRequest.getPassword());
        
        UserLoginResponse loginResponse = loginService.login(loginRequest);
        
        // アクセストークンを発行
        if(loginResponse.getResult().equals("0")) {
            UUID randomUUID = UUID.randomUUID();
            UserSession userSession = new UserSession();
            userSession.setAccessToken(randomUUID.toString());
            userSession.setAccountId(loginResponse.getAccount().getAccountId());
//            userSession.setAdminRole(loginResponse.getLoginUser().getAdminRole());
//            userSession.setStaffType(loginResponse.getLoginUser().getStaffType());
//            userSession.setUserGroup(loginResponse.getLoginUser().getUserGroup());
//            userSession.setUserId(loginResponse.getLoginUser().getUserId());
//            userSession.setUserName(loginResponse.getLoginUser().getUserName());
            usersSessionRepository.save(userSession);
            loginResponse.setAccessToken(randomUUID.toString());
        }
        

        // TODO session設定

        return loginResponse;
    }
}