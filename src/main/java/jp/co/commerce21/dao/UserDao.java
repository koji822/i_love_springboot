package jp.co.commerce21.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import jp.co.commerce21.entity.User;

@Component
public interface UserDao extends JpaRepository <User, Integer> {	
	public User findByUsername(String username);
}