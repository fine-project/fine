package excel;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Named;

@Named
public class ExcelReaderFactory {
	/** �N���C�A���g�p�X */
	private static String excellReaderPath;

	public static ExcelReader createReader() {
		try {
			return (ExcelReader) Class.forName(excellReaderPath).getDeclaredConstructor().newInstance();
		} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException("ExcelReader�C���X�^���X�����Ɏ��s���܂����B" + e);
		}
	}
}
