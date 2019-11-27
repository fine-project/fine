package fine.web.download;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

/**
 * ダウンロードヘルパ。
 * @author masanii15
 * @since 1.0
 */
public class DownloadHelper {

	public static final String CONTENT_DISPOSITION_KEY = "Content-Disposition";
    private static final String CONTENT_DISPOSITION_FORMAT
    = "attachment; filename=\"%s\"; filename*=UTF-8''%s";

	/**
	 * ダウンロード用ヘッダを付与
	 * @param response HttpServletResponse
	 * @param fileName ファイル名
	 */
	public static void addDownloadHeader(HttpServletResponse response, String fileName) {
		
		String encodedFilename;
		try {
			encodedFilename = URLEncoder.encode(fileName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e); // not happen
		}
		
        String value = String.format(CONTENT_DISPOSITION_FORMAT,
                fileName, encodedFilename);
        
        response.addHeader(CONTENT_DISPOSITION_KEY, value);
	}
	
}
