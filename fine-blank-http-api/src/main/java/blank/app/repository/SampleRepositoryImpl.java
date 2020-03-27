package blank.app.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.stereotype.Repository;

import com.fineframework.auth.entity.Account;
import com.fineframework.spring.repository.AccountRepositorySupport;

/**
 * @TODO 壊れている。修正中
 * @TODO 生産性確保のため、リポジトリのアダプタ。一旦インタフェースを作るのではなく、実装クラスを作る方針とする
 * @author masanii15
 * @since 1.0
 */
@Repository
public class SampleRepositoryImpl extends AccountRepositorySupport {

    public Account findByIdAndPassword(String userId, String password) {
        
        Account account = new Account();
        account.setUserId(userId);
        account.setPassword(password);
        
        String sql = "SELECT * from account WHERE user_id = :userId AND password = :password";

        List<Account> query = getJdbcTemplate().query(sql, new BeanPropertySqlParameterSource(account), new BeanPropertyRowMapper<>(Account.class));

        if(query.size() == 0) {
            return null;
        }
        
        return query.get(0);
    }

    

}
