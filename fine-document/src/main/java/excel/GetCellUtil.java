package excel;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class GetCellUtil {

	public static Object getCellValue;

	/** private */
	private GetCellUtil() {
	}

	public static void getCellValue(Sheet sheet, Object obj) {

		for (Field field : obj.getClass().getDeclaredFields()) {
			ExcelCellField annotation = field.getAnnotation(ExcelCellField.class);
			if (annotation == null) {
				continue;
			}
			field.setAccessible(true);

			Row row = sheet.getRow(annotation.row());
			Cell cell = row.getCell(annotation.cell());
			try {
				field.set(obj, getCellValue(cell));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void getListValue(Sheet sheet, Object obj) {

		for (Field field : obj.getClass().getDeclaredFields()) {
			ExcelListField listFiledAnnotation = field.getAnnotation(ExcelListField.class);
			if (listFiledAnnotation == null) {
				continue;
			}

			field.setAccessible(true);

		}
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