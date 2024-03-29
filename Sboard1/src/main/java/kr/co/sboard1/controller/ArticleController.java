package kr.co.sboard1.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.sboard1.service.ArticleService;
import kr.co.sboard1.vo.ArticleVo;
import kr.co.sboard1.vo.FileVo;
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
	public String list(@ModelAttribute("sessUser") UserVo sessUser, Model model, String pg) {
		
		// 로그인 체크
		if(sessUser == null) {
			return "redirect:/user/login?success=102";	
		}
		
		int currentPage = service.getCurrentPage(pg); 
		int total = service.selectCountTotal();
		int lastPageNum = service.getLastPageNum(total);
		int start = service.getLimitStart(currentPage);
		int pageStartNum = service.getPageStartNum(total, start);
		int groups[] = service.getPageGroup(currentPage, lastPageNum);
		
		List<ArticleVo> articles = service.selectArticles(start);
		
		model.addAttribute("articles", articles);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("groups", groups);
		
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
		
		return "redirect:/article/list";
	}
	
	@GetMapping("/article/view")
	public String view(@ModelAttribute("sessUser") UserVo sessUser, int no, Model model) {
		// 로그인 체크
		if(sessUser == null) {
			return "redirect:/user/login?success=102";	
		}
		
		ArticleVo article = service.selectArticle(no);
		
		model.addAttribute("article", article);
		
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
	
	
	@GetMapping("/article/filedownload")
	public void filedownload(int fid, HttpServletResponse resp) {
		// 파일 다운로드 카운트 +1
		
		// 파일 다운로드 정보조회
		FileVo fvo = service.selectFile(fid);
		
		// 파일 다운로드
		service.fileDownload(resp, fvo);
	}
	
	@ResponseBody
	@GetMapping("/article/comment/{no}")
	public List<ArticleVo> comment(@PathVariable("no")int no) {
		List<ArticleVo> comments = service.selectComments(no);
		return comments;
	}
	
	@ResponseBody
	@PostMapping("/article/comment")
	public Map<String, Integer> comment(ArticleVo vo, HttpServletRequest req) {
		
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		int result = service.insertComment(vo);
		
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		
		return map;
	}
	
	
	
	
}
