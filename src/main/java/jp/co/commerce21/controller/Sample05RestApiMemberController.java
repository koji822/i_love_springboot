package jp.co.commerce21.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.co.commerce21.entity.Member;
import jp.co.commerce21.service.MemberService;

@RestController
@RequestMapping("/sample05/api/member")
public class Sample05RestApiMemberController {

	@Autowired
    private MemberService memberService;
	
	@GetMapping(path = "/custom")
    public List<Member> getCustom(@RequestParam String inputText, String emailText) {
		return memberService.findByCustom(inputText, emailText);
    }
}
