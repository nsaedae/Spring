package kr.co.farmstory.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.farmstory.service.BoardService;
import kr.co.farmstory.vo.ArticleVo;

@SessionAttributes("sessUser")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	

	@GetMapping("/board/list")
	public String list(Model model, String cate, String type) {
		
		model.addAttribute("cate", cate);
		model.addAttribute("type", type);
		
		return "/board/list";
	}
	
	@GetMapping("/board/write")
	public String write(Model model, String cate, String type) {
		
		model.addAttribute("cate", cate);
		model.addAttribute("type", type);
		return "/board/write";
	}
	
	@PostMapping("/board/write")
	public String write(ArticleVo vo, HttpServletRequest req) {
		
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		service.insertArticle(vo);
		
		return "redirect:/board/list?cate="+vo.getCate()+"&type="+vo.getType();
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
