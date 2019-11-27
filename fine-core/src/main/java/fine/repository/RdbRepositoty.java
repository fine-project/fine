package fine.repository;

public interface RdbRepositoty<V> {

	/**
	 * Lockを取得し、更新用オブジェクトを取得する
	 * 
	 * @param entity エンティティ
	 * @return エンティティ
	 */
	V findByKeyWithLock(V entity);
}
