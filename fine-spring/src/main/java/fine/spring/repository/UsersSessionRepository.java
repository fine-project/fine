package fine.spring.repository;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.stereotype.Repository;

import fine.auth.entity.UserSession;

@Repository
public class UsersSessionRepository extends RdbRepositotySupport<UserSession> {

	private static final Logger LOGGER = LogManager.getLogger(UsersSessionRepository.class);

    @Override
    public UserSession findByKey(UserSession key) {
    	
		String sql = "SELECT access_token, account_id, TO_CHAR(updated_at, 'yyyymmddHH24miss') as updated_at FROM user_session WHERE access_token = :accessToken";

		List<UserSession> query = getJdbcTemplate().query(sql, new BeanPropertySqlParameterSource(key), new BeanPropertyRowMapper<>(UserSession.class));

		if(query.size() == 0) {
			return null;
		}
		
		return query.get(0);
	}

	@Override
	public <S extends UserSession> S save(S entity) {

		getJdbcTemplate().update("INSERT INTO "
				+ "user_session(access_token, account_id, created_at, updated_at)"
				+ " VALUES(:accessToken, :accountId, current_timestamp, current_timestamp)",
				new BeanPropertySqlParameterSource(entity));

		return null;
	}

	public void deleteAccessToekn() {

		getJdbcTemplate().update("delete from user_session where updated_at < now() - INTERVAL '60 minute'",
				new BeanPropertySqlParameterSource(new Object()));

	}

	public int updateUpdatedAt(UserSession entity) {

		return getJdbcTemplate().update(
				"update user_session set updated_at = current_timestamp where access_token = :accessToken",
				new BeanPropertySqlParameterSource(entity));

	}

	@Override
	public List<UserSession> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserSession> findByKeys(Set<? extends UserSession> entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserSession removeByKey(UserSession entityy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(UserSession entity) {
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