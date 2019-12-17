package excel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.inject.Named;

@Named
public class ExcelReaderFactory {
	/** クライアントパス */
	private static String excellReaderPath;

	private static Constructor<?> constrctor;

	public ExcelReader createReader() {
		try {
			// property読む実装
			excellReaderPath = "excel.ExcelReaderImpl";
			constrctor = Class.forName(excellReaderPath).getDeclaredConstructor();
			return (ExcelReader) constrctor.newInstance();
		} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException("ExcelReaderインスタンス生成に失敗しました。" + e);
		}
	}
}
