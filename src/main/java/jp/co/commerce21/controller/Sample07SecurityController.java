package jp.co.commerce21.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Sample07SecurityController {

	@RequestMapping(value="/sample07/index", method=RequestMethod.GET)
	public String index(Map<String, Object> model) {
		return "sample07/index";
	}
}
