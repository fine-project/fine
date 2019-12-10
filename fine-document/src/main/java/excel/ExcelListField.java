package excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Excel������ʒu���w�肷��A�m�e�[�V�����B DTO��Field�ɑ΂��ĕt�^����B
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelListField {
	int startRow() default 0;

	int startCell() default 0;
	
	int endRow() default 0;
}