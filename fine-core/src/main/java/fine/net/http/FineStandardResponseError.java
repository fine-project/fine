package fine.net.http;

public class FineStandardResponseError {
	/** エラーコード */
	private String error;
	/** エラー内容 */
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
