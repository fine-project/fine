package excel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

	@SuppressWarnings("unchecked")
	public static <T> T getCellValue(Sheet sheet, Class<T> clazz) {

		List<T> testList = new ArrayList<>();

		T t = null;
		try {
			t = clazz.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			ExcelCellField annotation = field.getAnnotation(ExcelCellField.class);
			if (annotation != null) {
				Row row = sheet.getRow(annotation.row());
				if (row != null) {
					Cell cell = row.getCell(annotation.cell());
					try {
						field.set(t, getCellValue(cell));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {
				ExcelListField listFiledAnnotation = field.getAnnotation(ExcelListField.class);
				if (listFiledAnnotation == null) {
					continue;
				}
				int startRow = listFiledAnnotation.startRow();
				int endRow = listFiledAnnotation.endRow();

				Row listRow = sheet.getRow(startRow);
				while (listRow != null) {
					if (endRow != 0 && startRow > endRow) {
						break;
					}
					if (field.getType().isAssignableFrom(List.class)) {
						ParameterizedType a = (ParameterizedType) field.getGenericType();
						Class<?> componentType = (Class<?>) a.getActualTypeArguments()[0];

						T t2 = null;
						try {
							t2 = (T) componentType.getDeclaredConstructor().newInstance();
						} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
								| InvocationTargetException | NoSuchMethodException | SecurityException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						for (Field innerField : componentType.getDeclaredFields()) {
							Column columnAnnotation = innerField.getAnnotation(Column.class);
							if (columnAnnotation == null) {
								continue;
							} else {
								innerField.setAccessible(true);
								int column = columnAnnotation.value();

								Cell cell = listRow.getCell(column);
								try {
									innerField.set(t2, getCellValue(cell));
								} catch (IllegalArgumentException | IllegalAccessException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						testList.add(t2);
					}
					listRow = sheet.getRow(++startRow);
				}
				try {
					field.set(t, testList);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return t;
	}

	/*
	 * @SuppressWarnings("unchecked") public static <T> T getListValue(Sheet sheet,
	 * Class<T> clazz) {
	 * 
	 * T t = null; try { t = clazz.getDeclaredConstructor().newInstance(); } catch
	 * (InstantiationException | IllegalAccessException | IllegalArgumentException |
	 * InvocationTargetException | NoSuchMethodException | SecurityException e1) {
	 * // TODO Auto-generated catch block e1.printStackTrace(); }
	 * 
	 * List<T> testList = new ArrayList<>();
	 * 
	 * for (Field field : clazz.getDeclaredFields()) { ExcelListField
	 * listFiledAnnotation = field.getAnnotation(ExcelListField.class); if
	 * (listFiledAnnotation == null) { continue; } field.setAccessible(true); int
	 * startRow = listFiledAnnotation.startRow(); int endRow =
	 * listFiledAnnotation.endRow();
	 * 
	 * Row row = sheet.getRow(startRow); while (row != null) { if (startRow >
	 * endRow) { break; } if (field.getType().isAssignableFrom(List.class)) {
	 * ParameterizedType a = (ParameterizedType) field.getGenericType(); Class<?>
	 * componentType = (Class<?>) a.getActualTypeArguments()[0];
	 * 
	 * T t2 = null; try { t2 = (T)
	 * componentType.getDeclaredConstructor().newInstance(); } catch
	 * (InstantiationException | IllegalAccessException | IllegalArgumentException |
	 * InvocationTargetException | NoSuchMethodException | SecurityException e1) {
	 * // TODO Auto-generated catch block e1.printStackTrace(); }
	 * 
	 * for (Field innerField : componentType.getDeclaredFields()) { Column
	 * columnAnnotation = innerField.getAnnotation(Column.class); if
	 * (columnAnnotation == null) { continue; } else {
	 * innerField.setAccessible(true); int column = columnAnnotation.value();
	 * 
	 * Cell cell = row.getCell(column); try { innerField.set(t2,
	 * getCellValue(cell)); } catch (IllegalArgumentException |
	 * IllegalAccessException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } } testList.add(t2); } row =
	 * sheet.getRow(++startRow); } try { field.set(t, testList); } catch (Exception
	 * e) { e.printStackTrace(); } }
	 * 
	 * return t; }
	 */

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