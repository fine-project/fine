package blank.app.login;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fineframework.auth.entity.Account;
import com.fineframework.net.http.FineStandardResponseBase;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserLoginResponse extends FineStandardResponseBase {

    private Account account;
    private Boolean showPasswordChange;
    private String accessToken;

    
    
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Boolean getShowPasswordChange() {
        return showPasswordChange;
    }

    public void setShowPasswordChange(Boolean showPasswordChange) {
        this.showPasswordChange = showPasswordChange;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    
    

}
