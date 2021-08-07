package jp.co.commerce21.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.commerce21.dto.GoodsDto;
import jp.co.commerce21.form.SearchGoodsForm;
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
	public String list(ModelMap model, SearchGoodsForm sgForm) {		
		// 一覧情報の取得
		List<GoodsDto> goodsList = goodsService.searchGoodsList(sgForm);		
		model.addAttribute("goodsList", goodsList);
		
		return "sample09/list";
	}
}
