package kr.co.ch08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.ch08.service.User2Service;
import kr.co.ch08.vo.User2Vo;


@SessionAttributes("sessUser")
@Controller
public class User3Controller {

	@Autowired
	private User2Service service;
	
	// 처음 sessUser값을 초기화하는 메서드 
	@ModelAttribute("sessUser")
	public User2Vo setUser2Vo() {
		return null;
	}
	
	@GetMapping("/user3/login")
	public String login(@ModelAttribute("sessUser") User2Vo sessUser) {
		
		if(sessUser == null) {
			return "/user3/login";
		}else {
			return "redirect:/user3/loginSuccess";
		}
	}
	
	@PostMapping("/user3/login")
	public String login(User2Vo vo, Model model) {
		
		User2Vo user = service.selectUser(vo);
		
		if(user == null) {
			return "redirect:/user3/login?success=100";
		}else {
			model.addAttribute("sessUser", user);
			return "redirect:/user3/loginSuccess";
		}
	}
	
	
	@GetMapping("/user3/logout")
	public String logout(SessionStatus status) {
		// @SessionAttributes로 설정한 세션 해제
		status.setComplete();
		
		return "redirect:/user3/login?success=103";
	}
	
		
	@GetMapping("/user3/register")
	public String register(@ModelAttribute("sessUser") User2Vo sessUser) {
		
		if(sessUser == null) {
			return "/user3/register";	
		}else {
			return "redirect:/user3/loginSuccess";
		}
	}
	
	@PostMapping("/user3/register")
	public String register(@ModelAttribute("sessUser") User2Vo sessUser, User2Vo vo) {
		service.insertUser(vo);
		return "redirect:/user3/login";
	}
	
	@GetMapping("/user3/loginSuccess")
	public String loginSuccess(@ModelAttribute("sessUser") User2Vo sessUser) {
		
		if(sessUser == null) {
			return "redirect:/user3/login?success=101";
		}else {
			return "/user3/loginSuccess";
		}
	}
	
}
