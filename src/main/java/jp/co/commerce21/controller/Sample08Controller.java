package jp.co.commerce21.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.commerce21.entity.Book;
import jp.co.commerce21.form.BookForm;
import jp.co.commerce21.service.impl.BookService;

@Controller
public class Sample08Controller {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/sample08/book", method = RequestMethod.GET)
	public String login(Model model) {
    	model.addAttribute("title", "本屋さん");
    	return "sample08/book";
	}
    
    @RequestMapping(value = "/sample08/book", method = RequestMethod.POST)
    public String index(BookForm bookForm, String showList, Model model) {

        // タイトル
        model.addAttribute("title", "本屋さん");

        // bookform（formクラス）がnullでなければ1件検索
        if (bookForm.getId() != null) {
            Book book = bookService.findById(bookForm.getId());
            model.addAttribute("book", book);
        }

        // 一覧表示ボタンが押されると本一覧をmodelに登録
        if (showList != null) {
            List<Book> bookList = bookService.getBookList();
            model.addAttribute("bookList", bookList);
        }

        return "sample08/book";
    }
}
