package com.fineframework.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.fineframework.repository.RdbRepositoty;
import com.fineframework.repository.Repositoty;

public abstract class RdbRepositotySupport<V> implements RdbRepositoty<V>, Repositoty<V> {

	@Autowired
	private JdbcTemplate jdbcTemplateStandard;
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public V findByKeyWithLock(V entity) {

		// get version no (use annotation)
		int no = 1;

		// バージョン番号更新
		int update = getJdbcTemplate().update("update " + getTableName() + " set version_no = " + no++
				+ " updated_at = current_timestamp where " + getWhereOfKey(),
				new BeanPropertySqlParameterSource(entity));

		V dbEntity = findByKey(entity);

		if (dbEntity == null) {
			throw new RuntimeException("ロック対象のデータが見つかりません");
		}

		return dbEntity;
	}

	protected abstract String getWhereOfKey();

	protected abstract String getTableName();

	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplateStandard() {
		return jdbcTemplateStandard;
	}

}