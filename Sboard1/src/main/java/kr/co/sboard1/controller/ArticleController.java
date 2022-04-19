package kr.co.sboard1.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.sboard1.service.ArticleService;
import kr.co.sboard1.vo.ArticleVo;
import kr.co.sboard1.vo.UserVo;


@SessionAttributes("sessUser")
@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService service;
	
	
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
	
	@PostMapping("/article/write")
	public String write(@ModelAttribute("sessUser") UserVo sessUser, ArticleVo vo, HttpServletRequest req) {
		// 로그인 체크
		if(sessUser == null) {
			return "redirect:/user/login?success=102";	
		}
		
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		service.insertArticle(vo);
				
		return "redirect:/article/list";
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