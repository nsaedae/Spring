package kr.co.ch08.controller;

import javax.servlet.http.HttpSession;

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
	public String login(HttpSession sess) {
		
		// 로그인 확인
		User2Vo user = (User2Vo) sess.getAttribute("sessUser");
		
		if(user == null) {
			return "/user2/login";	
		}else {
			return "redirect:/user2/loginSuccess";
		}
	}
		
	
	@PostMapping("/user2/login")
	public String login(User2Vo vo, HttpSession sess) {
		
		User2Vo user = service.selectUser(vo);
		
		if(user == null) {
			return "redirect:/user2/login?success=100";
		}else {
			// 세션처리
			sess.setAttribute("sessUser", user);
			
			return "redirect:/user2/loginSuccess";	
		}
	}
	
	@GetMapping("/user2/logout")
	public String logout(HttpSession sess) {
		// 세션 해제
		sess.invalidate();
		
		return "redirect:/user2/login?success=103";
	}
	
	
	@GetMapping("/user2/loginSuccess")
	public String loginSuccess(HttpSession sess) {
		
		// 로그인 확인
		User2Vo user = (User2Vo) sess.getAttribute("sessUser");
		
		if(user == null) {
			return "redirect:/user2/login?success=101";	
		}else {
			return "/user2/loginSuccess";
		}
	}
		
	@GetMapping("/user2/register")
	public String register(HttpSession sess) {
		// 로그인 확인
		User2Vo user = (User2Vo) sess.getAttribute("sessUser");
		
		if(user == null) {
			return "/user2/register";	
		}else {
			return "redirect:/user2/loginSuccess";
		}
	}
	
	@PostMapping("/user2/register")
	public String register(User2Vo vo) {
		
		service.insertUser(vo);
		
		return "redirect:/user2/login";
	}
}
