package excel;

/**
 * Excelから取る位置を指定するアノテーション。 DTOのFieldに対して付与する。
 */
public @interface ExcelCellFieldMapping {

	int row() default 0;

	int cell() default 0;

	String keyName();
}
