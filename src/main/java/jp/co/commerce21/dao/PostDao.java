package jp.co.commerce21.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import jp.co.commerce21.entity.Post;

@Component
public interface PostDao extends JpaRepository <Post, Long> {
	
}
