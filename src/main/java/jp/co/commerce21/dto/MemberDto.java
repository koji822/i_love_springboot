package jp.co.commerce21.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MemberDto {

	private Long id;

	private String text;
	
	private String email;
	
	private Date regDate;
	
	private Date upDate;
	
}
