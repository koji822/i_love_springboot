package jp.co.commerce21.util;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * テスト用クラス
 * @author Koji
 * 
 */
public class Test {
	public static void main(String[] args) {
		// エンコードされたパスワードを出力
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
