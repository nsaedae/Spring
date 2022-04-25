package kr.co.farmstory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@GetMapping("/board/list")
	public String list(Model model, String cate, String type) {
		
		
		
		model.addAttribute("cate", cate);
		model.addAttribute("type", type);
		
		return "/board/list";
	}
	
	@GetMapping("/board/write")
	public String write() {
		return "/board/write";
	}
	
	@GetMapping("/board/view")
	public String view() {
		return "/board/view";
	}
	
	@GetMapping("/board/modify")
	public String modify() {
		return "/board/modify";
	}
	
}
