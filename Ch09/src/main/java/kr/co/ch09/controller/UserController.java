package kr.co.ch09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ch09.service.UserService;
import kr.co.ch09.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@ResponseBody
	@GetMapping("/user")
	public List<UserVo> list() {
		List<UserVo> users = service.selectUsers();
		return users;
	}
	
	
}
