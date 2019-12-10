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
public @interface Column {
	int value() default 0;

}
