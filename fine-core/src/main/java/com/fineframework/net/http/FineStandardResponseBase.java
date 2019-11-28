package com.fineframework.net.http;

import java.util.ArrayList;
import java.util.List;

public class FineStandardResponseBase {

    public static final int SUCCESS = 0;
    public static final int FAILED = 1;

	/** å‡¦ç?çµæœã€‚æ?åŠŸ?¼?0ã€å¤±æ•—ï¼?1 */
	private String result;

	/** å‡¦ç?çµæœã€‚æ?åŠŸ?¼?0ã€å¤±æ•—ï¼?1 */
	private List<FineStandardResponseError> errors = new ArrayList<FineStandardResponseError>();

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setResult(int result) {
		this.result = String.valueOf(result);
	}


	public List<FineStandardResponseError> getErrors() {
		return errors;
	}

	public void setErrors(List<FineStandardResponseError> errors) {
		this.errors = errors;
	}
	
	public void addError(FineStandardResponseError error) {
		this.errors.add(error);
	}

}
