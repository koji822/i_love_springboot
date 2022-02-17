package jp.co.commerce21.form;

import lombok.Data;

@Data
public class ListDataModel {

	private String label;
	
	private String data;
	
	public ListDataModel(String _label, String _data) {
		this.label = _label;
		this.data = _data;
	}
}
