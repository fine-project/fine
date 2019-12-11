package excel;

import java.util.List;

public class TestDto {

	@ExcelCellField(row = 5, cell = 2)
	private String cellA;

	@ExcelCellField(row = 4, cell = 2)
	private String cellB;

	@ExcelCellField(row = 6, cell = 1)
	private String cellC;

	public String getCellA() {
		return cellA;
	}

	public void setCellA(String cellA) {
		this.cellA = cellA;
	}

	public String getCellB() {
		return cellB;
	}

	public void setCellB(String cellB) {
		this.cellB = cellB;
	}

	public String getCellC() {
		return cellC;
	}

	public void setCellC(String cellC) {
		this.cellC = cellC;
	}
//, endRow = 10
	@ExcelListField(startRow = 4, endRow = 10)
	private List<InnerDto> listMap;

	public List<InnerDto> getListMap() {
		return listMap;
	}

	public void setListMap(List<InnerDto> listMap) {
		this.listMap = listMap;
	}

}
