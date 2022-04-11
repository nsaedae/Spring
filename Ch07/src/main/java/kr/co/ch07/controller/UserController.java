package kr.co.ch07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.ch07.service.UserService;
import kr.co.ch07.vo.UserVo;


@Controller
public class UserController {
	
	@Autowired
	private UserService service;

	@GetMapping("/user/register")
	public String register() {
		return "/user/register";
	}
	
	@PostMapping("/user/register")
	public String register(UserVo vo) {
		
		service.insertUser(vo);
		return "redirect:/user/list";
	}
	
	@GetMapping("/user/list")
	public String list(Model model, String sort, Integer type) {
		
		List<UserVo> users = null;
		
		if(sort != null) {
			if(sort.equals("name")) {
				users = service.selectUsersOrderByName();
			}else if(sort.equals("age") && type == 1) {
				users = service.selectUsersOrderByAgeAsc();
			}else if(sort.equals("age") && type == 2) {
				users = service.selectUsersOrderByAgeDesc();
			}else if(sort.equals("age") && type == 3) {
				users = service.selectUserUnderAge30();
			}
		}
		else {
			users = service.selectUsers();
		}
		
		model.addAttribute("users", users);
		
		return "/user/list";
	}
	
	@GetMapping("/user/modify")
	public String modify(String uid, Model model) {
				
		UserVo user = service.selectUser(uid);
		model.addAttribute("user", user);
		
		return "/user/modify";
	}
	
	@PostMapping("/user/modify")
	public String modify(UserVo vo) {
		
		service.updateUser(vo);
		
		return "redirect:/user/list";
	}
	
	
	@GetMapping("/user/delete")
	public String delete(String uid) {
				
		service.deleteUser(uid);
		
		return "redirect:/user/list";
	}
	
	

}
