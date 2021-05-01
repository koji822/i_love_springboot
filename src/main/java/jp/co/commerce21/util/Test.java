package jp.co.commerce21.util;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Test {
	public static void main(String[] args) {
		
		System.out.println(encode("password1111"));     
	}
	
	private static String encode(String password) {
		return passwordEncoder().encode(password);
	}	
	
	@Bean
	private static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
