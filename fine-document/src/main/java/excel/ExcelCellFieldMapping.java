package excel;

/**
 * Excel������ʒu���w�肷��A�m�e�[�V�����B DTO��Field�ɑ΂��ĕt�^����B
 */
public @interface ExcelCellFieldMapping {

	int row() default 0;

	int cell() default 0;

	String keyName();
}
