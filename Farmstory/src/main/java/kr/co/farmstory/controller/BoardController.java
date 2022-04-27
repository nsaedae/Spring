package kr.co.farmstory.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.farmstory.service.BoardService;
import kr.co.farmstory.vo.ArticleVo;
import kr.co.farmstory.vo.FileVo;
import kr.co.farmstory.vo.UserVo;

@SessionAttributes("sessUser")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	// 처음 sessUser값을 초기화하는 메서드 
	@ModelAttribute("sessUser")
	public UserVo setUserVo() {
		return null;
	}
	
	
	@GetMapping("/board/list")
	public String list(Model model, String cate, String type) {
		
		model.addAttribute("cate", cate);
		model.addAttribute("type", type);
		
		return "/board/list";
	}
	
	@GetMapping("/board/write")
	public String write(@ModelAttribute("sessUser") UserVo sessUser, Model model, String cate, String type) {
		// 로그인 체크
		if(sessUser == null)
			return "redirect:/user/login?success=102";	
		
		
		model.addAttribute("cate", cate);
		model.addAttribute("type", type);
		
		return "/board/write";
	}
	
	@PostMapping("/board/write")
	public String write(@ModelAttribute("sessUser") UserVo sessUser, ArticleVo vo, HttpServletRequest req) {
		// 로그인 체크
		if(sessUser == null)
			return "redirect:/user/login?success=102";
		
		
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		if(vo.getFname().isEmpty()) {
			// 파일 첨부 안했을 때
			vo.setFile(0);
			service.insertArticle(vo);
		}else {
			// 파일 첨부 했을 때
			// 글 등록
			vo.setFile(1);
			int no = service.insertArticle(vo);
			
			// 파일 업로드
			FileVo fvo = service.fileUpload(vo.getFname());
			
			// 파일 등록
			fvo.setParent(no);
			service.insertFile(fvo);
		}
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
