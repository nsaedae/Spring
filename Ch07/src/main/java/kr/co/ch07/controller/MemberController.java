package kr.co.ch07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch07.service.MemberService;
import kr.co.ch07.vo.MemberVo;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	
	@PostMapping("/member/register")
	public String register(MemberVo vo) {
		service.insertMember(vo);
		return "redirect:/member/list";
	}
	
	@GetMapping("/member/list")
	public String list() {
		return "/member/list";
	}
	
}
