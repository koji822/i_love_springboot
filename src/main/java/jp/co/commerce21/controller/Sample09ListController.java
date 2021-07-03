package jp.co.commerce21.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.commerce21.dto.GoodsDto;
import jp.co.commerce21.form.SearchForm;
import jp.co.commerce21.service.GoodsService;

/**
 * 検索・一覧用コントローラクラス
 * 
 */
@Controller
public class Sample09ListController {
	
	@Autowired
	private GoodsService goodsService;
	
	/**
	 * 検索・一覧ページ
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sample09/list")
	public String list(ModelMap model, SearchForm searchForm, Pageable pageable) {
		// ページ処理
//		int page = pageable.getPageNumber() == 0 ? 1 : pageable.getPageNumber();
//		int count = memberService.searchMemberListCount(searchForm);
//		Pager pager = new Pager(pageable.getPageSize(), count, page);
		
		// 一覧情報の取得
		List<GoodsDto> goodsList = goodsService.searchGoodsList(searchForm);
		
		model.addAttribute("goodsList", goodsList);
//		model.addAttribute("page", pager);
//		model.addAttribute("del", model.get("del"));
		
		return "sample09/list";
	}
}
