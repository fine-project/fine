package excel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;


public class GetCellUtil {

	public static Object getCellValue;

	/** private */
	private GetCellUtil() {
	}

	public static <T> T getCellValue(Sheet sheet, Class<T> clazz) {

		for (Field field : clazz.getDeclaredFields()) {
			ExcelCellField annotation = field.getAnnotation(ExcelCellField.class);
			if (annotation == null) {
				continue;
			}
			field.setAccessible(true);

			Row row = sheet.getRow(annotation.row());
			if (row != null) {
				Cell cell = row.getCell(annotation.cell());
				try {
					field.set(clazz.getDeclaredConstructor().newInstance(), getCellValue(cell));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return (T) new Object();
	}

	public static <T> T getListValue(Sheet sheet, Class<T> clazz) {

		for (Field field : clazz.getDeclaredFields()) {
			for (Annotation test : field.getAnnotations()) {
				System.out.println(test.toString());
			}
			ExcelListField listFiledAnnotation = field.getAnnotation(ExcelListField.class);
			if (listFiledAnnotation == null) {
				continue;
			}
			if (field.getType().isAssignableFrom(List.class)) {
				Class<?> componentType = field.getType().getComponentType();
				for (Field field2 : componentType.getDeclaredFields()) {
					System.out.println("kita----");
					for (Annotation test : field.getAnnotations()) {
						System.out.println(test.toString());
					}
				}
			}

			field.setAccessible(true);

		}
		return null;
	}

	private static String getCellValue(Cell cell) {
		String value = null;
		if (cell != null) {
			switch (cell.getCellType()) {
			case STRING:
				value = cell.getStringCellValue();
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					value = new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue());
				} else {
					value = String.valueOf(cell.getNumericCellValue());
				}
				break;
			case BOOLEAN:
				value = String.valueOf(cell.getBooleanCellValue());
				break;
			case FORMULA:
				value = cell.getCellFormula();
				break;
			default:
				value = "";
				break;
			}
		}
		return value;
	}
}