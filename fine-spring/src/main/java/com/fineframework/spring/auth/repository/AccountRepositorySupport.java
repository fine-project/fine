package com.fineframework.spring.auth.repository;

import java.util.List;
import java.util.Set;

import javax.inject.Named;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;

import com.fineframework.auth.entity.Account;
import com.fineframework.auth.repository.AccountRepository;
import com.fineframework.repository.DataNotFoundException;
import com.fineframework.spring.repository.RdbRepositotySupport;

/**
 * TODO インデックス検索メソッドも追加
 * @author masanii15
 * @since 1.0
 */
@Named
public class AccountRepositorySupport extends RdbRepositotySupport<Account> implements AccountRepository {

    private String selectSQL = 
              "SELECT "
              + "account_id, " 
              + "user_id, " 
              + "last_name, " 
              + "first_name, " 
              + "mail_address, " 
              + "password, " 
              + "login_failure_count, " 
              + "last_login_failure_date_time, " 
              + "is_locked, " 
              + "last_login_date_time, " 
              + "created_user_id, " 
              + "created_user_date_time, " 
              + "updated_user_id, " 
              + "updated_user_date_time "
            + "FROM "
            + "  account ";

    private String selectCountSQL = 
            "SELECT "
            + "COUNT(*) " 
          + "FROM "
          + "  account ";

    private String insertSQL = 
            "INSERT "
              + "INTO account ( "
                + "account_id, " 
                + "user_id, " 
                + "last_name, " 
                + "first_name, " 
                + "mail_address, " 
                + "password, " 
                + "login_failure_count, " 
                + "last_login_failure_date_time, " 
                + "is_locked, " 
                + "last_login_date_time, " 
                + "created_user_id, " 
                + "created_user_date_time, " 
                + "updated_user_id, " 
                + "updated_user_date_time "
              + "VALUES ("
                + ":accountId, " 
                + ":userId, " 
                + ":lastName, " 
                + ":firstName, " 
                + ":mailAddress, " 
                + ":password, " 
                + ":loginFailureCount, " 
                + ":lastLoginFailureDateTime, " 
                + ":isLocked, " 
                + ":lastLoginDateTime, " 
                + ":insertUserId, " 
                + "current_timestamp, " 
                + ":updateUserId, " 
                + "current_timestamp "
              + ")";
    
            private String deleteSQL = 
                    "DELETE "
                    + "FROM "
                    + "  account "
                    + "WHERE "
                    + "  account_id = :accountId";


    @Override
    public Account findByKey(Account entity) {
        String sql = 
                  selectSQL
                  + "WHERE "
                  + "  account_id = :accountId";

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

    public Account findByUserId(Account entity) {
        String sql = 
                  selectSQL
                  + "WHERE "
                  + "  user_id = :userId";

        List<Account> query = getJdbcTemplate().query(sql, new BeanPropertySqlParameterSource(entity), new BeanPropertyRowMapper<>(Account.class));

        if(query.size() == 0) {
            throw new DataNotFoundException();
        }
        
        return query.get(0);
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
