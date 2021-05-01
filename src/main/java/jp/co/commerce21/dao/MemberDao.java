package jp.co.commerce21.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import jp.co.commerce21.entity.Member;

@Component
public interface MemberDao extends JpaRepository <Member, Long> {
	
	List<Member> findByInputText(@Param("inputText") String inputText);
	
	List<Member> findByEmailText(@Param("emailText") String emailText);
}
