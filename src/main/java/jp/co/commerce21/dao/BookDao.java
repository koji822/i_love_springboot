package jp.co.commerce21.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.commerce21.entity.Book;

@Mapper
public interface BookDao {
	// 1件検索
    public Book findById(Integer id);

    // 全件取得
    public List<Book> findAll();
}
