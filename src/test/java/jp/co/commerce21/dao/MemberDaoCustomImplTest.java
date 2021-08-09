package jp.co.commerce21.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import jp.co.commerce21.entity.Member;
import jp.co.commerce21.form.SearchForm;

@SpringBootTest
@Transactional
class MemberDaoCustomImplTest {

	@Autowired
	private MemberDaoCustom memberDaoCustom;
	
	@Test
	void searchMemberCountTestパラメータ有 () {
		// テストデータ
		SearchForm searchForm = new SearchForm();
		searchForm.setId(1L);
		searchForm.setText("text");
		searchForm.setEmail("test@example.com");
		
		// テストデータで対象のメソッドを実行
		int actual = memberDaoCustom.searchMemberCount(searchForm);
		
		// 判定
		assertThat(actual).isEqualTo(1);	
	}
	
	@Test
	void searchMemberCountTestパラメータ無 () {
		// テストデータ
		SearchForm searchForm = new SearchForm();
		
		// テストデータで対象のメソッドを実行
		int actual = memberDaoCustom.searchMemberCount(searchForm);
		
		// 判定
		assertThat(actual).isEqualTo(1);		
	}
	
	@Test
	void searchMemberTestパラメータ有 () {
		// テストデータ
		int offset = 0;
		int size = 10;
		SearchForm searchForm = new SearchForm();
		searchForm.setId(1L);
		searchForm.setText("text");
		searchForm.setEmail("test@example.com");
		
		// テストデータで対象のメソッドを実行
		List<Member> actual = memberDaoCustom.searchMember(searchForm, offset, size);
		
		// 判定
		assertThat(actual.size()).isEqualTo(1);	
	}
	
	@Test
	void searchMemberTestパラメータ無 () {
		// テストデータ
		int offset = 0;
		int size = 10;		
		SearchForm searchForm = new SearchForm();
		
		// テストデータで対象のメソッドを実行
		List<Member> actual = memberDaoCustom.searchMember(searchForm, offset, size);
		
		// 判定
		assertThat(actual.size()).isEqualTo(1);	
	}
	
	@Test
	void findByInputTextAndEmailTextTestパラメータ有01 () {
		// テストデータ
		String text = "testaaa";
		String email = "test@example.comaaa";
		
		// テストデータで対象のメソッドを実行
		List<Member> actual = memberDaoCustom.findByInputTextAndEmailText(text, email);
		
		// 判定
		assertThat(actual.size()).isEqualTo(0);	
	}
	
	@Test
	void findByInputTextAndEmailTextTestパラメータ有02 () {
		// テストデータ
		String text = "testaaa";
		String email = null;
		
		// テストデータで対象のメソッドを実行
		List<Member> actual = memberDaoCustom.findByInputTextAndEmailText(text, email);
		
		// 判定
		assertThat(actual.size()).isEqualTo(0);	
	}
	
	@Test
	void findByInputTextAndEmailTextTestパラメータ有03 () {
		// テストデータ
		String text = "";
		String email = "test@example.comaaa";
		
		// テストデータで対象のメソッドを実行
		List<Member> actual = memberDaoCustom.findByInputTextAndEmailText(text, email);
		
		// 判定
		assertThat(actual.size()).isEqualTo(0);	
	}
	
	@Test
	void findByInputTextAndEmailTextTestパラメータ無01 () {
		// テストデータ
		String text = "";
		String email = "";
		
		// テストデータで対象のメソッドを実行
		List<Member> actual = memberDaoCustom.findByInputTextAndEmailText(text, email);
		
		// 判定
		assertThat(actual.size()).isEqualTo(1);	
	}
	
	@Test
	void findByInputTextAndEmailTextTestパラメータ無02 () {
		// テストデータ
		String text = null;
		String email = null;
		
		// テストデータで対象のメソッドを実行
		List<Member> actual = memberDaoCustom.findByInputTextAndEmailText(text, email);
		
		// 判定
		assertThat(actual.size()).isEqualTo(1);	
	}
	
}
