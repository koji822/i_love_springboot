package jp.co.commerce21.form;

public class ListDataModel {

	private String label;
	private String data;
	
	public ListDataModel(String _label, String _data) {
		this.label = _label;
		this.data = _data;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
