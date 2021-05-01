package jp.co.commerce21.service;

import java.util.List;

import jp.co.commerce21.form.PostForm;

public interface PostService {

	public int updatePost(List<PostForm> posts);
	
	public void deleteAll();
}
