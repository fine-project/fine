package blank.app.account;

import java.util.List;

import com.fineframework.auth.entity.Account;

public class AccountsResponse {
    
    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    
}
