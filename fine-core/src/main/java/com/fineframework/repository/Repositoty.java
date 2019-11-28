package com.fineframework.repository;

import java.util.List;
import java.util.Set;

public interface Repositoty<V> {

	/**
	 * 1件取得
	 **/
	V findByKey(V entity);

	/**
	 * 全件取得
	 **/
	List<V> findAll();

	/**
	 * 複数主キー検索
	 **/
	List<V> findByKeys(Set<? extends V> entity);

	/**
	 * 保存。
	 * <p>
	 * RDBの場合、キーに紐づくデータが存在するならINSERT。存在しなければUPDATE
	 * </p>
	 **/
	<S extends V> S save(S entity);

	/**
	 * キーで削除。
	 **/
	V removeByKey(V entityy);

	/**
	 * キーが存在するかどうか
	 **/
	boolean exists(V entity);

}