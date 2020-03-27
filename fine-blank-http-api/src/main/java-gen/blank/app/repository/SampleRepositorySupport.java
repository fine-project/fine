package blank.app.repository;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.fineframework.auth.entity.Account;
import com.fineframework.spring.repository.RdbRepositotySupport;

/**
 * @TODO 壊れている。修正中
 * @TODO 自動生成される予定のリポジトリサポート
 * パッケージプライベートとすることで、Adaptor経由でのアクセスを強制する
 * @author masanii15
 * @since 1.0
 */
@Repository
class SampleRepositorySupport extends RdbRepositotySupport<Account> implements SampleRepository {

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
