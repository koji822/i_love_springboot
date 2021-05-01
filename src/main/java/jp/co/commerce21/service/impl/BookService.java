package jp.co.commerce21.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.commerce21.dao.BookDao;
import jp.co.commerce21.entity.Book;

@Service
public class BookService {

	@Autowired
    BookDao bookDao;

    // 1件検索
    public Book findById(Integer id) {
        return this.bookDao.findById(id);
    }

    // 全件取得
    public List<Book> getBookList() {
        return this.bookDao.findAll();
    }
}
