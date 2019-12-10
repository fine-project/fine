package excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Excelから取る位置を指定するアノテーション。 DTOのFieldに対して付与する。
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelListField {
	int startRow() default 0;

	int startCell() default 0;
	
	int endRow() default 0;
}