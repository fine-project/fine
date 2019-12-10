package excel;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class GetCellUtil {

	public static Object getCellValue;

	/** private */
	private GetCellUtil() {
	}

	public static Map<String, String> getCellValue(Sheet sheet, Object obj) {
		Map<String, String> valueMap = new HashMap<>();
		if (obj == null) {
			return null;
		}
		Class<?> clazz = obj.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			ExcelCellField annotation = field.getAnnotation(ExcelCellField.class);
			if (annotation == null) {
				continue;
			}
			field.setAccessible(true);

			for (ExcelCellFieldMapping testMapping : annotation.fieldMapping()) {
				Row row = sheet.getRow(testMapping.row());
				Cell cell = row.getCell(testMapping.cell());
				String keyname = testMapping.keyName();
				valueMap.put(keyname, getCellValue(cell));
			}
		}
		return valueMap;
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