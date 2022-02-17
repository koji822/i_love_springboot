package jp.co.commerce21.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
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
}

