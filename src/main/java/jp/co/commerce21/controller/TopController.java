package jp.co.commerce21.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Topページ用コントローラクラス
 *
 */
@Controller
public class TopController {
	
	@Value("${top.title}")
	private String title;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String top(Map<String, Object> model) {
		return "redirect:/sample";
	}
	
	@RequestMapping(value="/sample", method=RequestMethod.GET)
	public String sample(Map<String, Object> model) {
		model.put("title", this.title);
		return "top";
	}
}
