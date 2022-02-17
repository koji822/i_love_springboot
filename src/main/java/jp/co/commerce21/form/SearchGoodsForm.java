package jp.co.commerce21.form;

import lombok.Data;

@Data
public class SearchGoodsForm {

	private Long no;
	
	private String name;

	public void setName(String name) {
		if (name.isEmpty()) {
			name = null;
		}
		this.name = name;
	}	
}
