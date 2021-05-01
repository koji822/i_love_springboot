package jp.co.commerce21.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserAccount implements UserDetails {

	private static final long serialVersionUID = 1L;

	private User user;
	private Collection<GrantedAuthority> authorities;
		
	protected UserAccount(){}
	
	public UserAccount(User account, Collection<GrantedAuthority> authorities){
		this.user = account;
		this.authorities = authorities;		
	}	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}
}
