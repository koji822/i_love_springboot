package jp.co.commerce21.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import jp.co.commerce21.entity.Member;

@Component
public interface MemberDao extends JpaRepository <Member, Long> {
	
	Member findByEmailText(@Param("emailText") String emailText);
}
