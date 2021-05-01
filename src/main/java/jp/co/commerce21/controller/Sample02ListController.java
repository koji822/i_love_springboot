package jp.co.commerce21.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.commerce21.common.page.Pager;
import jp.co.commerce21.dto.MemberDto;
import jp.co.commerce21.form.SearchForm;
import jp.co.commerce21.service.MemberService;

/**
 * 検索・一覧用コントローラクラス
 * 
 */
@Controller
public class Sample02ListController {
	
	@Autowired
	private MemberService memberService;
	
	/**
	 * 検索・一覧ページ
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sample02/list")
	public String list(ModelMap model, SearchForm searchForm, Pageable pageable) {
		// ページ処理
		int page = pageable.getPageNumber() == 0 ? 1 : pageable.getPageNumber();
		int count = memberService.searchMemberListCount(searchForm);
		Pager pager = new Pager(pageable.getPageSize(), count, page);
		
		// 一覧情報の取得
		List<MemberDto> memberList = memberService.searchMemberList(searchForm, pager);
		
		model.addAttribute("members", memberList);
		model.addAttribute("page", pager);
		model.addAttribute("del", model.get("del"));
		
		return "sample02/list";
	}
	
	/**
	 * 削除処理
	 * 
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value="/sample02/delete", method=RequestMethod.POST)
	public String delete(RedirectAttributes redirectAttributes, @RequestParam("id") Long id) {
		// 削除処理
		memberService.delete(id);
		
		redirectAttributes.addFlashAttribute("del", id);
		
		return "redirect:list";
	}
}
