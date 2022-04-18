package kr.co.sboard1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {

	@GetMapping("/article/list")
	public String list() {
		return "/article/list";
	}
	@GetMapping("/article/write")
	public String write() {
		return "/article/write";
	}
	@GetMapping("/article/view")
	public String view() {
		return "/article/view";
	}
	@GetMapping("/article/modify")
	public String modify() {
		return "/article/modify";
	}
	
}
