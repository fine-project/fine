package com.fineframework.auth.repository;

import com.fineframework.auth.entity.Account;
import com.fineframework.repository.RdbRepositoty;
import com.fineframework.repository.Repositoty;

/**
 * @author masanii15
 * @since 1.0
 */
public interface AccountRepository extends RdbRepositoty<Account>, Repositoty<Account> {

}
