package kr.co.ch08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch08.service.User2Service;
import kr.co.ch08.vo.User2Vo;

@Controller
public class User2Controller {

	@Autowired
	private User2Service service;
	
	@GetMapping("/user2/login")
	public String login() {
		return "/user2/login";
	}
	
	@PostMapping("/user2/login")
	public String login(User2Vo vo) {
		
		User2Vo user = service.selectUser(vo);
		
		if(user == null) {
			return "redirect:/user2/login?success=100";
		}else {
			// 세션처리
			
			
			return "redirect:/user2/loginSuccess";	
		}
	}
	
	
	@GetMapping("/user2/loginSuccess")
	public String loginSuccess() {
		return "/user2/loginSuccess";
	}
	
	
	@GetMapping("/user2/register")
	public String register() {
		return "/user2/register";
	}
	
	@PostMapping("/user2/register")
	public String register(User2Vo vo) {
		
		service.insertUser(vo);
		
		return "redirect:/user2/login";
	}
}
