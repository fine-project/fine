package blank.app.login;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fineframework.auth.entity.Account;
import com.fineframework.net.http.FineStandardResponseBase;
import com.fineframework.net.http.FineStandardResponseError;
import com.fineframework.repository.DataNotFoundException;
import com.fineframework.security.digest.SHA256Digester;
import com.fineframework.spring.repository.AccountRepositorySupport;

@Service
@Transactional
public class UserLoginService {

    @Autowired
    private AccountRepositorySupport accountRepository;
    @Autowired
    private SHA256Digester sha256Digester;

    public UserLoginResponse login(UserLoginRequest loginRequest) {

        UserLoginResponse loginResponse = new UserLoginResponse();

        // パスワード暗号化
        byte[] passwordHash;
        try {
            passwordHash = sha256Digester.digest(loginRequest.getPassword().getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String passwordHashOfHex = DatatypeConverter.printHexBinary(passwordHash);

        // ログイン実行
        Account key = new Account();
        key.setUserId(loginRequest.getUserId());
        
        Account account = null;
        
        try {
            account = accountRepository.findByUserId(key);
        } catch (DataNotFoundException e) {
        }

        if (account == null || !account.getPassword().equals(passwordHashOfHex)) {
            loginResponse.setResult(FineStandardResponseBase.FAILED);
            FineStandardResponseError responseError = new FineStandardResponseError("LOGIN_ERROR",
                    "ユーザIDとパスワードの組み合わせが不正です");
            loginResponse.addError(responseError);
        } else {
            loginResponse.setAccount(account);
            ;
//            if (loginRequest.getPassword().equals(loginRequest.getUserId())) {
//                loginResponse.setResult(FineStandardResponseBase.SUCCESS);
//                loginResponse.setShowPasswordChange(true);
//            } else {
            loginResponse.setResult(FineStandardResponseBase.SUCCESS);
//            }
        }
        return loginResponse;
    }
}