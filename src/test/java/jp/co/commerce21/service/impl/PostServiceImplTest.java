package jp.co.commerce21.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import jp.co.commerce21.dao.PostDao;
import jp.co.commerce21.form.PostForm;
import jp.co.commerce21.service.PostService;

@SpringBootTest
@Transactional
public class PostServiceImplTest {
	
	@Mock
	private PostDao postDao;
	
	@InjectMocks
	private PostService postService = new PostServiceImpl();

	@Test
	public void updatePostメソッドテスト() throws Exception {
		int actual = postService.updatePost(this.setPostFormList());
		assertThat(actual).isEqualTo(0);		
	}
	
	/**
	 * PostFormテストデータを設定
	 * @return postFormのリスト
	 */
	private List<PostForm> setPostFormList() {		
		List<PostForm> posts = new ArrayList<PostForm>();
		PostForm postForm = new PostForm();
		postForm.setZipCode("1820023");
		postForm.setZipCodeOld("108");
		postForm.setPrefCode("13103");
		postForm.setPrefName("東京都");
		postForm.setPrefNameKana("ﾄｳｷｮｳﾄ");
		postForm.setCityName("港区");
		postForm.setCityNameKana("ﾐﾅﾄｸ");
		postForm.setTownareaName("芝浦（２～４丁目）");
		postForm.setTownareaNameKana("ｼﾊﾞｳﾗ(2-4ﾁｮｳﾒ)");
		postForm.setRemarks01("1");
		postForm.setRemarks02("0");
		postForm.setRemarks03("1");
		postForm.setRemarks04("0");
		postForm.setRemarks05("0");
		postForm.setRemarks06("0");
		posts.add(postForm);
		
		return posts;
	}
}
