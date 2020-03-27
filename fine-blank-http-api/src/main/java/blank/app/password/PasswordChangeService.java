package blank.app.password;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fineframework.auth.entity.Account;
import com.fineframework.auth.entity.UserSession;
import com.fineframework.net.http.FineStandardResponseBase;
import com.fineframework.spring.repository.AccountRepositorySupport;

@Service
@Transactional
public class PasswordChangeService {
	
	@Autowired
	private AccountRepositorySupport accountRepository;
	
	public PasswordChangeResponse passwordChange(String password, UserSession user) {
		
		PasswordChangeResponse response = new PasswordChangeResponse();
		
		Account account = new Account();
        BeanUtils.copyProperties(user, account);

		Account dbAccount = accountRepository.findByKeyWithLock(account);
		dbAccount.setPassword(password);

		accountRepository.save(account);
		
		response.setResult(FineStandardResponseBase.SUCCESS);

		return response;
	}
}
