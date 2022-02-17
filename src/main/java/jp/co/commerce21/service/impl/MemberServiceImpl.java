package jp.co.commerce21.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.commerce21.common.page.Pager;
import jp.co.commerce21.dao.MemberDao;
import jp.co.commerce21.dao.MemberDaoCustom;
import jp.co.commerce21.dto.MemberDownloadDto;
import jp.co.commerce21.dto.MemberDto;
import jp.co.commerce21.entity.Member;
import jp.co.commerce21.form.MemberForm;
import jp.co.commerce21.form.SearchForm;
import jp.co.commerce21.service.MemberService;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberDaoCustom memberDaoCustom;
	
	@Override
	public int registMember(MemberForm sForm) {
		
		Member member = new Member();
		member.setInputText(sForm.getInputText());
		member.setPassText(sForm.getPassText());
		member.setEmailText(sForm.getEmailText());
		member.setCalendarText(sForm.getCalendarText());
		member.setAreaText(sForm.getAreaText());
		member.setCheckBoxText(sForm.getCheckBoxText());
		
		String[] checksBoxText = sForm.getChecksBoxText();
		
		if (checksBoxText.length > 0) {
			member.setChecksBoxText(String.join(",", checksBoxText));
		}
		
		member.setRadioBoxText(sForm.getRadioBoxText());
		member.setSelectBoxText(sForm.getSelectBoxText());
		
		String[] selectsBoxText = sForm.getSelectsBoxText();
		
		if (selectsBoxText.length > 0) {
			member.setSelectsBoxText(String.join(",", selectsBoxText));
		}	
		
		member.setUpDm(new Date());
		
		if (sForm.getMemberId() == null) {
			member.setRegDm(new Date());
		} else {
			Member befMember = this.findById(sForm.getMemberId());
			member.setMemberId(befMember.getMemberId());
			member.setRegDm(befMember.getRegDm());
		}
		
		// 新規登録・編集
		memberDao.save(member);

		return 0;
	}
	
	@Override
	public int searchMemberListCount(SearchForm searchForm) {		 
		return memberDaoCustom.searchMemberCount(searchForm);
	}
	
	@Override
	public List<MemberDto> searchMemberList(SearchForm searchForm, Pager pager) {
		
		// 検索条件を元に一覧情報の取得
		List<Member> memberList = memberDaoCustom.searchMember(searchForm, pager.offset(), pager.size());

		List<MemberDto> memberDto = new ArrayList<MemberDto>();
		
		// EntityをDtoに変換
		for(Member list : memberList) {
			MemberDto member = new MemberDto();			
			member.setId(list.getMemberId());
			member.setText(list.getInputText());
			member.setEmail(list.getEmailText());
			member.setRegDate(list.getRegDm());
			member.setUpDate(list.getUpDm());			
			memberDto.add(member);
		}
		
		return memberDto;
	}

	@Override
	public List<MemberDownloadDto> findAllForDownload() {
		
		// 全件取得
		List<Member> memberList = memberDao.findAll();
		
		List<MemberDownloadDto> memberDto = new ArrayList<MemberDownloadDto>();
		
		// EntityをDtoに変換
		for(Member list : memberList) {
			MemberDownloadDto member = new MemberDownloadDto();			
			member.setId(list.getMemberId());
			member.setText(list.getInputText());
			member.setPass(list.getPassText());
			member.setEmail(list.getEmailText());
			member.setCalendar(list.getCalendarText());
			member.setArea(list.getAreaText());
			member.setCheckBox(list.getCheckBoxText());
			member.setChecksBox(list.getChecksBoxText());
			member.setRadioBox(list.getRadioBoxText());
			member.setSelectBox(list.getSelectBoxText());
			member.setSelectsBox(list.getSelectsBoxText());
			member.setRegDate(list.getRegDm());
			member.setUpDate(list.getUpDm());			
			memberDto.add(member);
		}
		
		return memberDto;
	}
	
	@Override
	public List<Member> findAll() {
		return memberDao.findAll();
	}
	
	@Override
	public Member findById(Long id) {
		return memberDao.getById(id);
//		return memberDao.getOne(id);
//		return memberDao.findOne(id);
	}
	
	@Override
	public void delete(Long id) {
		memberDao.deleteById(id);
//		memberDao.delete(id);
	}

	@Override
	public List<Member> findByCustom(String inputText, String emailText) {
		return memberDaoCustom.findByInputTextAndEmailText(inputText, emailText);
	}
}
