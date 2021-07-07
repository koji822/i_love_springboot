package jp.co.commerce21.form;

public class SearchGoodsForm {

	private Long no;
	
	private String name;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.isEmpty()) {
			name = null;
		}
		this.name = name;
	}
	
	
}
