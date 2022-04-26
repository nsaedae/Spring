package kr.co.farmstory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.farmstory.service.UserService;
import kr.co.farmstory.vo.TermsVo;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/user/login")
	public String login() {
		return "/user/login";
	}
	
	@GetMapping("/user/terms")
	public String terms(Model model) {
		
		TermsVo terms = service.selectTerms();
		model.addAttribute(terms);
		
		return "/user/terms";
	}
	
	@GetMapping("/user/register")
	public String register() {
		return "/user/register";
	}
	
}
