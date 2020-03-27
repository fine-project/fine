package blank.app.account;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fineframework.auth.entity.Account;
import com.fineframework.spring.auth.useridpassword.AccountService;

@RestController
@CrossOrigin
@RequestMapping("/accounts")
public class AccountController {

    private static final Logger LOGGER = LogManager.getLogger(AccountController.class);

    @Inject
    private AccountService accountService;

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public AccountsResponse getAllAccount(HttpServletRequest request) {
        
        List<Account> accounts = accountService.getAllAccount();
        AccountsResponse response = new AccountsResponse();
        response.setAccounts(accounts); 

        return response;
    }
    
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public AccountsResponse getAccount(@PathVariable Integer accountId, HttpServletRequest request) {
        
        Account account = accountService.getAccount(accountId);
        GetAccountResponse response = new GetAccountResponse();
        response.setAccount(account); 
        
        return null;
    }
    
    public class GetAllAccountResponse {
        private List<Account> accounts;
        public List<Account> getAccounts() {
            return accounts;
        }
        public void setAccounts(List<Account> accounts) {
            this.accounts = accounts;
        }
    }
    public class GetAccountResponse {
        private Account account;
        public Account getAccount() {
            return account;
        }
        public void setAccount(Account account) {
            this.account = account;
        }
    }

}