package jp.co.commerce21.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MyStringUtilsTest {
	
	@BeforeAll
    static void setUp() {
		// これを入れないとカバレッジ100%にならないからとりあえず入れる
		new MyStringUtils();
	}
	
	@Test
	void setCsvStrNullテスト() {		
		String actual = MyStringUtils.setCsvStr(null);
		assertThat(actual).isEqualTo("\"\"");
	}
	
	@Test
	void setCsvStr空文字テスト() {
		String actual = MyStringUtils.setCsvStr("");
		assertThat(actual).isEqualTo("\"\"");	
	}
	
	@Test
	void setCsvStr半角文字列テスト() {
		String actual = MyStringUtils.setCsvStr("abcde");
		assertThat(actual).isEqualTo("\"abcde\"");
	}

	@Test
	void setCsvStr全角文字列テスト() {
		String actual = MyStringUtils.setCsvStr("あいうえお");
		assertThat(actual).isEqualTo("\"あいうえお\"");
	}
	
	@Test
	void csvDqDelNullテスト() {
		String actual = MyStringUtils.csvDqDel(null);
		assertThat(actual).isEqualTo("");	
	}
	
	@Test
	void csvDqDel空文字テスト() {
		String actual = MyStringUtils.csvDqDel("");
		assertThat(actual).isEqualTo("");	
	}
	
	@Test
	void csvDqDel半角文字列テスト() {
		String actual = MyStringUtils.csvDqDel("ab\"cde");
		assertThat(actual).isEqualTo("abcde");
	}

	@Test
	void csvDqDel全角文字列テスト() {
		String actual = MyStringUtils.csvDqDel("あい\"うえお");
		assertThat(actual).isEqualTo("あいうえお");
	}
	
	@Test
	void isBlankNullテスト() {
		boolean actual = MyStringUtils.isBlank(null);
		assertThat(actual).isEqualTo(true);
	}
	
	@Test
	void isBlank空文字テスト() {
		boolean actual = MyStringUtils.isBlank("");
		assertThat(actual).isEqualTo(true);
	}
	@Test
	void isBlank半角文字列テスト01() {
		boolean actual = MyStringUtils.isBlank("a");
		assertThat(actual).isEqualTo(false);
	}
	
	@Test
	void isBlank半角文字列テスト02() {
		boolean actual = MyStringUtils.isBlank("test@email.com");
		assertThat(actual).isEqualTo(false);
	}
	
	@Test
	void isBlank半角文字列テスト03() {
		boolean actual = MyStringUtils.isBlank(" ");
		assertThat(actual).isEqualTo(true);
	}
	
	@Test
	void isBlank全角文字列テスト01() {
		boolean actual = MyStringUtils.isBlank("あ");
		assertThat(actual).isEqualTo(false);
	}
	
	@Test
	void isBlank全角文字列テスト02() {
		boolean actual = MyStringUtils.isBlank("あああ");
		assertThat(actual).isEqualTo(false);
	}
	
	@Test
	void isBlank全角文字列テスト03() {
		boolean actual = MyStringUtils.isBlank("　");
		assertThat(actual).isEqualTo(true);
	}
}
