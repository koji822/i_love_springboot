package jp.co.commerce21.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BookForm {
	
	private Integer id;
	
	private String bookName;
	
    private Integer volumeNum;
    
    private String authorName;
    
    private LocalDate publishedDate;
}
