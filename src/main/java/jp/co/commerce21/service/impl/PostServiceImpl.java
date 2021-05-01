package jp.co.commerce21.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.commerce21.dao.PostDao;
import jp.co.commerce21.entity.Post;
import jp.co.commerce21.form.PostForm;
import jp.co.commerce21.service.PostService;

@Service
@Transactional
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostDao postDao;
	
	@Override
	public int updatePost(List<PostForm> posts) {		
		// 削除
		deleteAll();
		
		for (PostForm pForm : posts) {
			Post post = new Post();
			post.setZipCode(pForm.getZipCode());
			post.setZipCodeOld(pForm.getZipCodeOld());
			post.setPrefCode(pForm.getPrefCode());
			post.setPrefNameKana(pForm.getPrefNameKana());
			post.setCityNameKana(pForm.getCityNameKana());
			post.setTownareaNameKana(pForm.getTownareaNameKana());
			post.setPrefName(pForm.getPrefName());
			post.setCityName(pForm.getCityName());
			post.setTownareaName(pForm.getTownareaName());
			post.setRemarks01(pForm.getRemarks01());
			post.setRemarks02(pForm.getRemarks02());
			post.setRemarks03(pForm.getRemarks03());
			post.setRemarks04(pForm.getRemarks04());
			post.setRemarks05(pForm.getRemarks05());
			post.setRemarks06(pForm.getRemarks06());
			
			// 新規登録
			postDao.save(post);
		}
		
		return 0;
	}

	@Override
	public void deleteAll() {
		postDao.deleteAll();
	}
}
