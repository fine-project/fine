package com.fineframework.auth.service;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AccountService {

    
	public void login() {
//
//		UserLoginResponse loginResponse = new UserLoginResponse();
//
//		// パスワード暗号化
//		byte[] passwordHash;
//        try {
//            passwordHash = sha256Digester.digest(loginRequest.getPassword().getBytes("utf-8"));
//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException(e);
//        }
//		String passwordHashOfHex = DatatypeConverter.printHexBinary(passwordHash);
//
//		// ログイン実行
//		Account account = accountRepository.findByIdAndPassword(
//		        loginRequest.getUserId(), passwordHashOfHex);
//
//        if (null == account) {
//            loginResponse.setResult(FineStandardResponseBase.FAILED);
//            FineStandardResponseError responseError = new FineStandardResponseError("LOGIN_ERROR", "ユーザIDとパスワードの組み合わせが不正です");
//            loginResponse.addError(responseError);
//        } else {
//            loginResponse.setAccount(account);;
////            if (loginRequest.getPassword().equals(loginRequest.getUserId())) {
////                loginResponse.setResult(FineStandardResponseBase.SUCCESS);
////                loginResponse.setShowPasswordChange(true);
////            } else {
//                loginResponse.setResult(FineStandardResponseBase.SUCCESS);
////            }
//        }
//		return loginResponse;
	}
}