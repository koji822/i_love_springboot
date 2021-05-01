package jp.co.commerce21.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.defaultSuccessUrl("/success").permitAll();
		
		http
			.csrf().ignoringAntMatchers("/sample03/**");
		
/*
		http.authorizeRequests()
			.antMatchers("/css/**", "/img/**", "/js/**").permitAll()
			.anyRequest().authenticated()
			.and()
			
			.formLogin()
			.loginPage("/login")
			.usernameParameter("email")
			.passwordParameter("password")
			.failureUrl("/login-error")
			.defaultSuccessUrl("/sample")
			.permitAll()
			.and()
			
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID");
*/
		
	}
	
	@Autowired
	protected void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());		
	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//			.withUser("user").password(passwordEncoder().encode("password1111")).roles("USER");
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
	