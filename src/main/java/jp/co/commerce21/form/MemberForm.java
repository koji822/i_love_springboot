package jp.co.commerce21.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MemberForm {

	private Long memberId;

	@NotEmpty 
	@Size(min=4, max=20) 
	@Pattern(regexp="[a-zA-Z0-9]+")
	private String inputText;
	
	@NotEmpty 
	@Size(min=4, max=20) 
	@Pattern(regexp="[a-zA-Z0-9]+")
	private String passText;
	
	@NotEmpty
	@Email
	private String emailText;
	
	@NotEmpty
	private String calendarText;
	
	@NotEmpty
	@Size(max=30)
	private String areaText;
	
	@Pattern(regexp = "on")
	private String checkBoxText;
		
	@NotEmpty
	private String[] checksBoxText;
	
	@NotEmpty
	private String radioBoxText;
	
	@NotEmpty
	private String selectBoxText;
	
	@NotEmpty
	private String[] selectsBoxText;
	
	private Date regDm;
	
	private Date upDm;
	
	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	
	public String getInputText() {
		return inputText;
	}

	public void setInputText(String inputText) {
		this.inputText = inputText;
	}

	public String getPassText() {
		return passText;
	}

	public void setPassText(String passText) {
		this.passText = passText;
	}

	public String getEmailText() {
		return emailText;
	}

	public void setEmailText(String emailText) {
		this.emailText = emailText;
	}

	public String getCalendarText() {
		return calendarText;
	}

	public void setCalendarText(String calendarText) {
		this.calendarText = calendarText;
	}
	
	public String getAreaText() {
		return areaText;
	}

	public void setAreaText(String areaText) {
		this.areaText = areaText;
	}

	public String getCheckBoxText() {
		return checkBoxText;
	}

	public void setCheckBoxText(String checkBoxText) {
		this.checkBoxText = checkBoxText;
	}

	public String[] getChecksBoxText() {
		return checksBoxText;
	}

	public void setChecksBoxText(String[] checksBoxText) {
		this.checksBoxText = checksBoxText;
	}

	public String getRadioBoxText() {
		return radioBoxText;
	}

	public void setRadioBoxText(String radioBoxText) {
		this.radioBoxText = radioBoxText;
	}

	public String getSelectBoxText() {
		return selectBoxText;
	}

	public void setSelectBoxText(String selectBoxText) {
		this.selectBoxText = selectBoxText;
	}

	public String[] getSelectsBoxText() {
		return selectsBoxText;
	}

	public void setSelectsBoxText(String[] selectsBoxText) {
		this.selectsBoxText = selectsBoxText;
	}
	
	public Date getRegDm() {
		return regDm;
	}

	public void setRegDm(Date regDm) {
		this.regDm = regDm;
	}

	public Date getUpDm() {
		return upDm;
	}

	public void setUpDm(Date upDm) {
		this.upDm = upDm;
	}

}
