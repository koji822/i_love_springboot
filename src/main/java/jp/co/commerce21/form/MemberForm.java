package jp.co.commerce21.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jp.co.commerce21.validation.UniqueEmail;
import lombok.Data;

@Data
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
	@UniqueEmail
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
}
