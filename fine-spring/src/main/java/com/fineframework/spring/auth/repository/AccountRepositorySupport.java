package com.fineframework.spring.auth.repository;

import java.util.List;
import java.util.Set;

import javax.inject.Named;

import com.fineframework.auth.entity.Account;
import com.fineframework.auth.repository.AccountRepository;
import com.fineframework.spring.repository.RdbRepositotySupport;

/**
 * @author masanii15
 * @since 1.0
 */
@Named
public class AccountRepositorySupport extends RdbRepositotySupport<Account> implements AccountRepository {

	@Override
	public Account findByKey(Account entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findByKeys(Set<? extends Account> entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Account> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account removeByKey(Account entityy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Account entity) {
		// TODO Auto-generated method stub
		return false;
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

}
