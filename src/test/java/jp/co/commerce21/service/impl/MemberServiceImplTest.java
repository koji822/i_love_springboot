package jp.co.commerce21.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import jp.co.commerce21.common.page.Pager;
import jp.co.commerce21.dao.MemberDao;
import jp.co.commerce21.dao.MemberDaoCustom;
import jp.co.commerce21.dto.MemberDownloadDto;
import jp.co.commerce21.dto.MemberDto;
import jp.co.commerce21.entity.Member;
import jp.co.commerce21.form.MemberForm;
import jp.co.commerce21.form.SearchForm;
import jp.co.commerce21.service.MemberService;

@SpringBootTest
@Transactional
class MemberServiceImplTest {
	
	@Mock
	private MemberDao memberDao;
	
	@Mock
	private MemberDaoCustom memberDaoCustom;
	
	@InjectMocks
	private MemberService memberService = new MemberServiceImpl();
	
	@Test
	public void registMemberメソッドテスト01() throws Exception {
		int actual = memberService.registMember(this.setRegistMember01());
		assertThat(actual).isEqualTo(0);		
	}
	@Test
	public void registMemberメソッドテスト02() throws Exception {
		int actual = memberService.registMember(this.setRegistMember02());
		assertThat(actual).isEqualTo(0);		
	}
	
	@Test
	public void registMemberメソッドテスト03() throws Exception {
		/** 1. テスト準備 */
		// 戻り値のデータ作成
		Member mockMember = this.createMockMember();
		
		// memberDao.findOneメソッドが呼ばれたらmockMemberを返す
		when(this.memberDao.getOne(100L)).thenReturn(mockMember);
		
		/** 2. 判定 */
		int actual = memberService.registMember(this.setRegistMember03());
		assertThat(actual).isEqualTo(0);		
	}

	@Test
	public void searchMemberListCountメソッドテスト() throws Exception {
		/** 1. テスト準備 */
		// 検索条件を設定
		SearchForm searchForm = new SearchForm();
		searchForm.setEmail("test");
		
		// memberDaoCustom.searchMemberCountメソッドが呼ばれたら「1」を返す
		when(this.memberDaoCustom.searchMemberCount(searchForm)).thenReturn(1);
		
		/** 2. 判定 */
		int actual = memberService.searchMemberListCount(searchForm);
		assertThat(actual).isEqualTo(1);
	}
	
	@Test
	public void searchMemberListメソッドテスト() throws Exception {
		/** 1. テスト準備 */
		// 検索条件を設定
		SearchForm searchForm = new SearchForm();
		searchForm.setEmail("test");

		// pagerの設定
		int pageSize = 10;		// 1ページあたりの件数
		int count = 20;			// 全体の件数
		int currentPage = 1;	// 現在のページ
		int offset = 0;			// オフセット
		Pager pager = new Pager(pageSize, count, currentPage);

		// 戻り値のデータ作成
		List<Member> mockMembers = new ArrayList<Member>();
		mockMembers.add(this.createMockMember());

		// memberDaoCustom.searchMemberメソッドが呼ばれたら「mockMembers」を返す
		when(this.memberDaoCustom.searchMember(searchForm, offset, pageSize)).thenReturn(mockMembers);

		/** 2. 判定 */
		List<MemberDto> actual = memberService.searchMemberList(searchForm, pager);
		assertThat(actual.size()).isEqualTo(1);
	}
	
	@Test
	public void findAllForDownloadメソッドテスト01() throws Exception {
		/** 1. テスト準備 */
		// 戻り値のデータ作成 (1件)
		List<Member> mockMembers = new ArrayList<Member>();
		mockMembers.add(createMockMember());
		
		// memberDao.findAll()メソッドが呼ばれたらmockMembersを返す
		when(this.memberDao.findAll()).thenReturn(mockMembers);
		
		/** 2. 判定 */
		List<MemberDownloadDto> actual = memberService.findAllForDownload();
		assertThat(actual.size()).isEqualTo(1);
	}
	
	@Test
	public void findAllForDownloadメソッドテスト02() throws Exception {
		/** 1. テスト準備 */
		// 戻り値のデータ作成 (0件)
		List<Member> mockMembers = new ArrayList<Member>();
		
		// memberDao.findAll()メソッドが呼ばれたらmockMembersを返す
		when(this.memberDao.findAll()).thenReturn(mockMembers);
		
		/** 2. 判定 */
		List<MemberDownloadDto> actual = memberService.findAllForDownload();
		assertThat(actual.size()).isEqualTo(0);
	}
	
	@Test
	public void findAllメソッドテスト() throws Exception {
		/** 1. テスト準備 */
		// 戻り値のデータ作成 (1件)
		List<Member> mockMembers = new ArrayList<Member>();
		mockMembers.add(createMockMember());
		
		// memberDao.findAll()メソッドが呼ばれたらmockMembersを返す
		when(this.memberDao.findAll()).thenReturn(mockMembers);
		
		/** 2. 判定 */
		List<Member> actual = memberService.findAll();
		assertThat(actual.size()).isEqualTo(1);
	}
	
	@Test
	public void deleteメソッドテスト() throws Exception {
		try {
			memberService.delete(10L);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void findByCustomメソッドテスト() throws Exception {
		/** 1. テスト準備 */
		// 
		String inputText = "test";
		String emailText = "test@yahoo.co.jp";

		// 戻り値のデータ作成
		List<Member> mockMembers = new ArrayList<Member>();
		mockMembers.add(this.createMockMember());

		// memberDaoCustom.findByInputTextAndEmailTextメソッドが呼ばれたら「mockMembers」を返す
		when(this.memberDaoCustom.findByInputTextAndEmailText(inputText, emailText)).thenReturn(mockMembers);

		/** 2. 判定 */
		List<Member> actual = memberService.findByCustom(inputText, emailText);
		assertThat(actual.size()).isEqualTo(1);
	}
	
	/**
	 * 登録用メンバーの設定 パターン1
	 * @return MemberForm
	 */
	private MemberForm setRegistMember01() {
		MemberForm member = new MemberForm();
		member.setInputText("test1229");
		member.setPassText("pass");
		member.setEmailText("test@yahoo.co.jp");
		member.setCalendarText("2017-12-31 23:55");
		member.setAreaText("テキストエリア");
		member.setCheckBoxText("A");
		String[] cbt = new String[2];
		cbt[0] = "A";
		cbt[1] = "B";
		// 複数選択
		member.setChecksBoxText(cbt);
		member.setRadioBoxText("on");
		member.setSelectBoxText("A");
		String[] sbt = new String[2];
		sbt[0] = "A";
		sbt[1] = "B";
		// 複数選択
		member.setSelectsBoxText(sbt);
		member.setUpDm(new Date());
		// 新規登録
		member.setMemberId(null);
		
		return member;
	}
	
	/**
	 * 登録用メンバーの設定 パターン2
	 * @return MemberForm
	 */
	private MemberForm setRegistMember02() {		
		MemberForm member = new MemberForm();
		member.setInputText("1229test");
		member.setPassText("passpass");
		member.setEmailText("test@gmail.com");
		member.setCalendarText("2017-08-22 23:55");
		member.setAreaText("テキストエリア<a href='http'>aaa</a>");
		member.setCheckBoxText("B");
		String[] cbt = new String[2];
		// 選択しない
		member.setChecksBoxText(cbt);
		member.setRadioBoxText("on");
		member.setSelectBoxText("A");
		String[] sbt = new String[2];
		// 選択しない
		member.setSelectsBoxText(sbt);
		member.setUpDm(new Date());
		// 新規登録
		member.setMemberId(null);
		
		return member;
	}
	
	/**
	 * 登録用メンバーの設定 パターン3
	 * @return MemberForm
	 */
	private MemberForm setRegistMember03() {		
		MemberForm member = new MemberForm();
		member.setInputText("1229test");
		member.setPassText("passpass");
		member.setEmailText("test@gmail.com");
		member.setCalendarText("2017-08-22 23:55");
		member.setAreaText("テキストエリア<a href='http'>aaa</a>");
		member.setCheckBoxText("B");
		String[] cbt = new String[2];
		cbt[0] = "A";
		// 1つ選択
		member.setChecksBoxText(cbt);
		member.setRadioBoxText("on");
		member.setSelectBoxText("A");
		String[] sbt = new String[2];
		sbt[0] = "B";
		// 1つ選択
		member.setSelectsBoxText(sbt);
		member.setUpDm(new Date());
		// 新規登録
		member.setMemberId(100L);
		member.setRegDm(new Date());
		
		return member;
	}
	
	private Member createMockMember() {
		// 戻り値のデータ作成
		Member mockMember = new Member();
		mockMember.setMemberId(100L);
		mockMember.setInputText("1229test");
		mockMember.setPassText("passpass");
		mockMember.setEmailText("test@gmail.com");
		mockMember.setCalendarText("2017-08-22 23:55");
		mockMember.setAreaText("テキストエリア<a href='http'>aaa</a>");
		mockMember.setCheckBoxText("B");
		mockMember.setChecksBoxText("A,B");
		mockMember.setRadioBoxText("on");
		mockMember.setSelectBoxText("A");
		mockMember.setSelectsBoxText("A");
		mockMember.setRegDm(new Date());		
		mockMember.setUpDm(new Date());
		return mockMember;
	}
}
	