package jp.co.commerce21.controller;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.commerce21.entity.Member;
import jp.co.commerce21.form.MemberForm;
import jp.co.commerce21.service.MemberService;

/**
 * 
 * 新規登録用コントローラクラス
 * 
 */
@Controller
public class Sample01RegistController {
	
	@Autowired
	private MemberService memberService;
	
	/**
	 * 入力ページ
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sample01/input", method=RequestMethod.GET)
	public String input(ModelMap model, MemberForm memberForm) {		
		model.addAttribute("title", "サンプル入力ページ");
		model.addAttribute("selectItems", SELECT_ITEMS);
		model.addAttribute("checkItems", CHECK_ITEMS);
		model.addAttribute("radioItems", RADIO_ITEMS);

		return "sample01/input";
	}
	
	/**
	 * 確認ページ
	 * 
	 * @param memberForm
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sample01/input", method=RequestMethod.POST)
    public String confirm(@ModelAttribute("memberForm") @Valid MemberForm memberForm, 
    		BindingResult result, ModelMap model) {

        if (result.hasErrors()) {

            model.addAttribute("title", "サンプル入力ページ  [ERROR]");
            model.addAttribute("selectItems", SELECT_ITEMS);
            model.addAttribute("checkItems", CHECK_ITEMS);
            model.addAttribute("radioItems", RADIO_ITEMS);
            
            return "sample01/input";
        }

        model.addAttribute("title", "サンプル確認ページ");

        return "sample01/confirm";
    }
	
	/**
	 * 入力ページへ戻る
	 * 
	 * @param memberForm
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sample01/input", method=RequestMethod.POST, params="revise")
    public String revise(@ModelAttribute("memberForm") MemberForm memberForm, ModelMap model) {
        model.addAttribute("title", "サンプル入力ページ");
        model.addAttribute("selectItems", SELECT_ITEMS);
        model.addAttribute("checkItems", CHECK_ITEMS);
        model.addAttribute("radioItems", RADIO_ITEMS);   

        return "sample01/input";
    }
	
	/**
	 * 登録・編集処理
	 * 
	 * @param memberForm
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sample01/input", method=RequestMethod.POST, params="confirmed")
    public String decide(@ModelAttribute("memberForm") MemberForm memberForm, BindingResult result, ModelMap model) {        
        if (result.hasErrors()) {
            return "redirect:/error";
        }
       
	    // 新規登録・編集処理
	    memberService.registMember(memberForm);

        return "redirect:complete";
    }
	
	/**
	 * 完了ページ
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sample01/complete", method=RequestMethod.GET)
    public String complete(ModelMap model) {
        model.addAttribute("title", "サンプル完了ページ");
        
        return "sample01/complete";
    }
	
	/**
	 * 入力ページ
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sample01/input/{id}", method=RequestMethod.GET)
	public String inputMod(@PathVariable("id") Long id, ModelMap model, MemberForm memberForm) {		
		Member member = memberService.findById(id);
		
		model.addAttribute("title", "サンプル入力ページ");
		model.addAttribute("selectItems", SELECT_ITEMS);
		model.addAttribute("checkItems", CHECK_ITEMS);
		model.addAttribute("radioItems", RADIO_ITEMS);
		model.addAttribute("memberForm", member);
		
		return "sample01/input";
	}
	
	/**
	 * selectの表示に使用するアイテム
	 */
	final static Map<String, String> SELECT_ITEMS = 
			Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put(" select_A", "A");
			put(" select_B", "B");
			put(" select_C", "C");
			put(" select_D", "D");
			put(" select_E", "E");
		}
	});
	
	/**
	 * check boxの表示に使用するアイテム
	 */
	final static Map<String, String> CHECK_ITEMS =
			Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put(" checkbox_A", "A");
			put(" checkbox_B", "B");
		}
	});
	
	/**
	 * radio buttonの表示に使用するアイテム
	 */
	final static Map<String, String> RADIO_ITEMS =
			Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
		private static final long serialVersionUID = 1L;	
		{
			put(" radio_A", "A");
			put(" radio_B", "B");
		}
	});
}

