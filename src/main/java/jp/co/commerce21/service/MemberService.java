package jp.co.commerce21.service;

import java.util.List;

import jp.co.commerce21.common.page.Pager;
import jp.co.commerce21.dto.MemberDownloadDto;
import jp.co.commerce21.dto.MemberDto;
import jp.co.commerce21.entity.Member;
import jp.co.commerce21.form.MemberForm;
import jp.co.commerce21.form.SearchForm;

public interface MemberService {

	public int registMember(MemberForm member);
	
	public int searchMemberListCount(SearchForm searchForm);
	
	public List<MemberDto> searchMemberList(SearchForm searchForm, Pager pager);
	
	public List<Member> findAll();
	
	public Member findById(Long id);
	
	public void delete(Long id);
	
	public List<MemberDownloadDto> findAllForDownload();
	
	public List<Member> findByCustom(String inputText, String emailText);
}
