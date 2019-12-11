package excel;

public class InnerDto {

	@Column(value = 0)
	private String hoge;
	@Column(value = 2)
	private String hoge2;
	@Column(value = 7)
	private String hoge3;

	public String getHoge() {
		return hoge;
	}

	public void setHoge(String hoge) {
		this.hoge = hoge;
	}

	public String getHoge2() {
		return hoge2;
	}

	public void setHoge2(String hoge2) {
		this.hoge2 = hoge2;
	}

	public String getHoge3() {
		return hoge3;
	}

	public void setHoge3(String hoge3) {
		this.hoge3 = hoge3;
	}

}
