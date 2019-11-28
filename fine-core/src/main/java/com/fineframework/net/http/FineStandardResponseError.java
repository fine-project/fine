package com.fineframework.net.http;

public class FineStandardResponseError {
	/** エラーコー�? */
	private String error;
	/** エラー�?容 */
	private String errorDescription;
	
	public FineStandardResponseError(String error, String errorDescription) {
		this.error = error;
		this.errorDescription = errorDescription;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
}
