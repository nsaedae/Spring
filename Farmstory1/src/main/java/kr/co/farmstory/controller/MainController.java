package kr.co.farmstory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.farmstory.service.MainService;
import kr.co.farmstory.vo.ArticleVo;

@Controller
public class MainController {
	
	@Autowired
	private MainService service;

	@GetMapping(value = {"/", "/index"})
	public String index(Model model) {
		
		// 최신글 가져오기
		List<ArticleVo> latest1 = service.selectLatest("grow");
		List<ArticleVo> latest2 = service.selectLatest("school");
		List<ArticleVo> latest3 = service.selectLatest("story");
		
		model.addAttribute("latest1", latest1);
		model.addAttribute("latest2", latest2);
		model.addAttribute("latest3", latest3);
		
		return "/index";
	}
	
}
