package excel;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Named;

@Named
public class ExcelReaderFactory {
	/** クライアントパス */
	private static String excellReaderPath;

	public static ExcelReader createReader() {
		try {
			return (ExcelReader) Class.forName(excellReaderPath).getDeclaredConstructor().newInstance();
		} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException("ExcelReaderインスタンス生成に失敗しました。" + e);
		}
	}
}
