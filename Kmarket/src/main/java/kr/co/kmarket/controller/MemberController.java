package kr.co.kmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.kmarket.service.MemberService;
import kr.co.kmarket.vo.MemberVo;

@SessionAttributes("sessMember")
@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;

	@GetMapping("/member/join")
	public String join() {
		return "/member/join";
	}
	
	@GetMapping("/member/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}
	
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	@PostMapping("/member/login")
	public String login(MemberVo vo, Model model) {
		
		MemberVo member = service.selectMember(vo);
		
		if(member == null) {
			return "redirect:/member/login?success=100"; 
		}else {
			model.addAttribute("sessMember", member);
			return "redirect:/";
		}
	}
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	@GetMapping("/member/register-seller")
	public String registerSeller() {
		return "/member/register-seller";
	}
	@GetMapping("/member/signup")
	public String signup() {
		return "/member/signup";
	}
	
	
}
