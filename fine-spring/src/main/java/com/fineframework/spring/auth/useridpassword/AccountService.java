package com.fineframework.spring.auth.useridpassword;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.fineframework.auth.entity.Account;
import com.fineframework.spring.repository.AccountRepositorySupport;

@Named
public class AccountService {

    @Inject
    private AccountRepositorySupport accountRepository;

    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }
    
    public Account getAccount(Integer accountId) {
        Account accountParam = new Account();
        accountParam.setAccountId(accountId);
        Account account = accountRepository.findByKey(accountParam);
        return account;
    }
    
    
}
