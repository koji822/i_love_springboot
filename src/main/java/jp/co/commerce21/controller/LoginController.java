package jp.co.commerce21.controller;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Loginページ用コントローラクラス
 *
 */
@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Map<String, Object> model) {
		 model.put("iserror", false);
		 return "login";
	}
	
	@RequestMapping(value = "/login-error", method = RequestMethod.GET)
	public String loginError(Map<String, Object> model) {
		 model.put("iserror", true);
		 return "login";
	}
	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String success(Authentication loginUser, Model model) {
		// 認証情報を取得
        model.addAttribute("username", loginUser.getName());
        model.addAttribute("role", loginUser.getAuthorities());
        return "redirect:/sample";
	}
}
