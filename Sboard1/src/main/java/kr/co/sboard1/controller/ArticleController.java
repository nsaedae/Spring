package kr.co.sboard1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.sboard1.vo.UserVo;


@SessionAttributes("sessUser")
@Controller
public class ArticleController {
	
	// 처음 sessUser값을 초기화하는 메서드 
	@ModelAttribute("sessUser")
	public UserVo setUserVo() {
		return null;
	}

	@GetMapping("/article/list")
	public String list(@ModelAttribute("sessUser") UserVo sessUser) {
		
		// 로그인 체크
		if(sessUser == null) {
			return "redirect:/user/login?success=102";	
		}
		
		return "/article/list";
	}
	@GetMapping("/article/write")
	public String write(@ModelAttribute("sessUser") UserVo sessUser) {
		// 로그인 체크
		if(sessUser == null) {
			return "redirect:/user/login?success=102";	
		}
				
		return "/article/write";
	}
	@GetMapping("/article/view")
	public String view(@ModelAttribute("sessUser") UserVo sessUser) {
		// 로그인 체크
		if(sessUser == null) {
			return "redirect:/user/login?success=102";	
		}
		
		return "/article/view";
	}
	@GetMapping("/article/modify")
	public String modify(@ModelAttribute("sessUser") UserVo sessUser) {
		// 로그인 체크
		if(sessUser == null) {
			return "redirect:/user/login?success=102";	
		}
		
		return "/article/modify";
	}
	
}
