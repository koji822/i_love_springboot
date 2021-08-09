package jp.co.commerce21.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.commerce21.dao.MemberDaoCustom;
import jp.co.commerce21.entity.Member;
import jp.co.commerce21.form.SearchForm;
import jp.co.commerce21.util.MyStringUtils;

@Component
public class MemberDaoCustomImpl implements MemberDaoCustom {

	@Autowired
	EntityManager manager;
	
	@Override
	public int searchMemberCount(SearchForm searchForm) {
		
		boolean idFlg = false;
		boolean textFlg = false;
		boolean emailFlg = false;
		
		StringBuilder sql = new StringBuilder();
	    sql.append("select m	 from Member m where 1=1 ");
	    
	    // Id
	    if (searchForm.getId() != null) {
	    	sql.append("and member_id = :member_id ");
	    	idFlg = true;
	    }
	    
	    // Text
	    if (!MyStringUtils.isBlank(searchForm.getText())) {
	    	sql.append("and input_text like :input_text ");
	    	textFlg = true;
	    }
	    
	    // Email
	    if (!MyStringUtils.isBlank(searchForm.getEmail())) {
	    	sql.append("and email_text like :email_text ");
	    	emailFlg = true;
	    }
	    
	    sql.append("order by member_id ");
	    
	    Query query = manager.createQuery(sql.toString());
	    if (idFlg) {
	    	query.setParameter("member_id", searchForm.getId());
	    }
	    if (textFlg) {
	    	query.setParameter("input_text", "%" + searchForm.getText() + "%");
	    }
	    if (emailFlg) {
	    	query.setParameter("email_text", "%" + searchForm.getEmail() + "%");
	    }
	    
	    return query.getResultList().size();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Member> searchMember(SearchForm searchForm, int offset, int size) {
		
		boolean idFlg = false;
		boolean textFlg = false;
		boolean emailFlg = false;
		
		StringBuilder sql = new StringBuilder();
	    sql.append("select m from Member m where 1=1 ");
	    
	    // Id
	    if (searchForm.getId() != null) {
	    	sql.append("and member_id = :member_id ");
	    	idFlg = true;
	    }
	    
	    // Text
	    if (!MyStringUtils.isBlank(searchForm.getText())) {
	    	sql.append("and input_text like :input_text ");
	    	textFlg = true;
	    }
	    
	    // Email
	    if (!MyStringUtils.isBlank(searchForm.getEmail())) {
	    	sql.append("and email_text like :email_text ");
	    	emailFlg = true;
	    }
	    
	    sql.append("order by member_id ");
	    
	    Query query = manager.createQuery(sql.toString());
	    if (idFlg) {
	    	query.setParameter("member_id", searchForm.getId());
	    }
	    if (textFlg) {
	    	query.setParameter("input_text", "%" + searchForm.getText() + "%");
	    }
	    if (emailFlg) {
	    	query.setParameter("email_text", "%" + searchForm.getEmail() + "%");
	    }
	    
	    query.setFirstResult(offset).setMaxResults(size);
	    
	    return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> findByInputTextAndEmailText(String inputText, String emailText) {
		
		boolean textFlg = false;
		boolean emailFlg = false;
		
		StringBuilder sql = new StringBuilder();
	    sql.append("select m from Member m where 1=1 ");
	    
	    // Text
	    if (!MyStringUtils.isBlank(inputText)) {
	    	sql.append("and input_text like :input_text ");
	    	textFlg = true;
	    }
	    
	    // Email
	    if (!MyStringUtils.isBlank(emailText)) {
	    	sql.append("and email_text like :email_text ");
	    	emailFlg = true;
	    }
	    
	    sql.append("order by member_id ");
	    
	    Query query = manager.createQuery(sql.toString());
	    if (textFlg) {
	    	query.setParameter("input_text", "%" + inputText + "%");
	    }
	    if (emailFlg) {
	    	query.setParameter("email_text", "%" + emailText + "%");
	    }
	    
	    return query.getResultList();
	}
}
