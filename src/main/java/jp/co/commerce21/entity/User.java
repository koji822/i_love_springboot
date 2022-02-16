package jp.co.commerce21.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tuser")
public class User {

//	public User(String username, String password, boolean isAdmin){
//		setUserId(0L);
//		setUsername(username);
//		setPassword(password);
//		setEnabled(true);
//		setAdmin(isAdmin);
//	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private Long userId;	
	
	@Column(name="username", length=20, nullable=false, unique = true)
	private String username;
	
	@Column(name="password", length=100, nullable=false)
	private String password;
	
	@Column(nullable = false)
    private boolean enabled;
	
	@Column(nullable = false)
    private boolean admin;
}

