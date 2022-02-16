package jp.co.commerce21.dto;

import java.util.Date;

import lombok.Data;

@Data
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
	
}
