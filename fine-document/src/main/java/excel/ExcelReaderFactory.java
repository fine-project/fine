package excel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.inject.Named;

@Named
public class ExcelReaderFactory {
	/** �N���C�A���g�p�X */
	private static String excellReaderPath;

	private static Constructor<?> constrctor;

	public ExcelReader createReader() {
		try {
			// property�ǂގ���
			excellReaderPath = "excel.ExcelReaderImpl";
			constrctor = Class.forName(excellReaderPath).getDeclaredConstructor();
			return (ExcelReader) constrctor.newInstance();
		} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException("ExcelReader�C���X�^���X�����Ɏ��s���܂����B" + e);
		}
	}
}
