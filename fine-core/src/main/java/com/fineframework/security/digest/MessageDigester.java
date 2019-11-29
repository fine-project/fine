package com.fineframework.security.digest;

/**
 * ハッシュ化を行うクラスが実装すべきインタフェース。
 * @author masanii15
 * @since 1.0
 */
public interface MessageDigester {

    byte[] digest(byte[] bytes);

}
