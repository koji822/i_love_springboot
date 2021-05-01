package jp.co.commerce21.dao;


import java.util.List;

import org.springframework.stereotype.Component;

import jp.co.commerce21.entity.Member;
import jp.co.commerce21.form.SearchForm;

@Component
public interface MemberDaoCustom {
	
	public int searchMemberCount(SearchForm searchForm);
	
	public List<Member> searchMember(SearchForm searchForm, int offset, int size);
	
	public List<Member> findByInputTextAndEmailText(String inputText, String emailText);
}

