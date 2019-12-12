package excel;

public interface ExcelReader {
	
	void initialize(String filePath);
	
	public <T> T getCellValue(String sheetPage, Class<T> clazz);

	void close();
}
