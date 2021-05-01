package jp.co.commerce21.dto;

import java.util.Date;

public class MemberDownloadDto {

	private Long id;

	private String text;
	
	private String pass;
	
	private String email;
	
	private String calendar;
	
	private String area;
	
	private String checkBox;
	
	private String checksBox;
	
	private String radioBox;
	
	private String selectBox;

	private String selectsBox;
	
	private Date regDate;
	
	private Date upDate;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCalendar() {
		return calendar;
	}

	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCheckBox() {
		return checkBox;
	}

	public void setCheckBox(String checkBox) {
		this.checkBox = checkBox;
	}

	public String getChecksBox() {
		return checksBox;
	}

	public void setChecksBox(String checksBox) {
		this.checksBox = checksBox;
	}

	public String getRadioBox() {
		return radioBox;
	}

	public void setRadioBox(String radioBox) {
		this.radioBox = radioBox;
	}

	public String getSelectBox() {
		return selectBox;
	}

	public void setSelectBox(String selectBox) {
		this.selectBox = selectBox;
	}

	public String getSelectsBox() {
		return selectsBox;
	}

	public void setSelectsBox(String selectsBox) {
		this.selectsBox = selectsBox;
	}
	
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpDate() {
		return upDate;
	}

	public void setUpDate(Date upDate) {
		this.upDate = upDate;
	}
}
