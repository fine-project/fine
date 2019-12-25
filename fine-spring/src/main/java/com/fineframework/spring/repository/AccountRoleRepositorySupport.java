package com.fineframework.spring.repository;

import java.util.List;
import java.util.Set;

import javax.inject.Named;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;

import com.fineframework.auth.entity.Account;
import com.fineframework.auth.repository.AccountRepository;
import com.fineframework.repository.DataNotFoundException;

/**
 * TODO インデックス検索メソッドも追加
 * @author masanii15
 * @since 1.0
 */
@Named
public class AccountRoleRepositorySupport extends RdbRepositotySupport<Account> implements AccountRepository {

    private String selectSQL = 
              "SELECT "
              + "account_id, " 
              + "role_id, " 
              + "created_user_id, " 
              + "created_user_date_time, " 
              + "updated_user_id, " 
              + "updated_user_date_time "
            + "FROM "
            + "  account_role ";

    private String selectCountSQL = 
            "SELECT "
            + "COUNT(*) " 
          + "FROM "
          + "  account_role ";

    private String insertSQL = 
            "INSERT "
              + "INTO account_role ( "
                + "account_id, " 
                + "role_id, " 
                + "created_user_id, " 
                + "created_user_date_time, " 
                + "updated_user_id, " 
                + "updated_user_date_time "
              + "VALUES ("
                + ":accountId, " 
                + ":roleId, " 
                + ":insertUserId, " 
                + "current_timestamp, " 
                + ":updateUserId, " 
                + "current_timestamp "
              + ")";
    
            private String deleteSQL = 
                    "DELETE "
                    + "FROM "
                    + "  account_role "
                    + "WHERE "
                    + "  account_id = :accountId"
                    + "  AND "
                    + "  role_id = :roleId";
                    ;


    @Override
    public Account findByKey(Account entity) {
        String sql = 
                  selectSQL
                  + "WHERE "
                  + "  account_id = :accountId"
                  + "  AND "
                  + "  role_id = :roleId";

        List<Account> query = getJdbcTemplate().query(sql, new BeanPropertySqlParameterSource(entity), new BeanPropertyRowMapper<>(Account.class));

        if(query.size() == 0) {
            throw new DataNotFoundException();
        }
        
        return query.get(0);
    }

    @Override
    public List<Account> findAll() {
        
        List<Account> results = getJdbcTemplate().query(selectSQL, new BeanPropertyRowMapper<>(Account.class));

        return results;
    }

    @Override
    public <S extends Account> S save(S entity) {

        getJdbcTemplate().update(insertSQL,
                new BeanPropertySqlParameterSource(entity));

        return null;
    }

    @Override
    public boolean exists(Account entity) {
        List<Account> query = getJdbcTemplate().query(selectCountSQL, new BeanPropertySqlParameterSource(entity), new BeanPropertyRowMapper<>(Account.class));
    	
    	return query.size() != 0;
    }

    @Override
    public Account removeByKey(Account entity) {
        
        int update = getJdbcTemplate().update(deleteSQL,
                new BeanPropertySqlParameterSource(entity));
        if(update == 0) {
            return null;
        }
        return new Account();
    }

    @Override
    protected String getWhereOfKey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String getTableName() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<Account> findByKeys(Set<? extends Account> entity) {
        // TODO Auto-generated method stub
        return null;
    }



}
