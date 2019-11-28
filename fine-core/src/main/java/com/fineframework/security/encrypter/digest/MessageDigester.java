package com.fineframework.security.encrypter.digest;

public interface MessageDigester {

    byte[] digest(byte[] bytes);

}
