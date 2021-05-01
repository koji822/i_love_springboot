package jp.co.commerce21.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tmember")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="member_id")
	private Long memberId;
	
	@Column(name="input_text", length=20, nullable=false)
	private String inputText;
	
	@Column(name="pass_text", length=20, nullable=false)
	private String passText;
	
	@Column(name="email_text", length=255, nullable=false)
	private String emailText;
	
	@Column(name="calendar_text", length=255, nullable=false)
	private String calendarText;
	
	@Column(name="area_text", length=1000, nullable=false)
	private String areaText;
	
	@Column(name="check_box_text", columnDefinition="char(2)")
	private String checkBoxText;
	
	@Column(name="checks_box_text", length=255)
	private String checksBoxText;
	
	@Column(name="radio_box_text", length=30, nullable=false)
	private String radioBoxText;
	
	@Column(name="select_box_text", length=30, nullable=false)
	private String selectBoxText;

	@Column(name="selects_box_text", length=255, nullable=false)
	private String selectsBoxText;
	
	@Column(name="reg_dm", nullable=false)
	private Date regDm;
	
	@Column(name="up_dm", nullable=false)
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

	public String getChecksBoxText() {
		return checksBoxText;
	}

	public void setChecksBoxText(String checksBoxText) {
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

	public String getSelectsBoxText() {
		return selectsBoxText;
	}

	public void setSelectsBoxText(String selectsBoxText) {
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

