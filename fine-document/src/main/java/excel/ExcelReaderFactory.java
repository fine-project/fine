package excel;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import javax.inject.Named;

@Named
public class ExcelReaderFactory {

	private static Constructor<?> constrctor;

	public ExcelReader createReader() {
		Properties prop = new Properties();
		InputStream stream = null;
		stream = getClass().getResourceAsStream("/ExcelReader.properties");
		try {
			prop.load(stream);
		} catch (IOException e1) {
			throw new RuntimeException("Propertyのロードが失敗しました。" + e1);
		}
		try {
			constrctor = Class.forName(prop.getProperty("excellReaderPath")).getDeclaredConstructor();
			return (ExcelReader) constrctor.newInstance();
		} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException |

				ClassNotFoundException e) {
			throw new RuntimeException("ExcelReaderの生成が失敗しました。" + e);
		}
	}
}
