package kr.co.ch09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@ResponseBody
	@PostMapping("/user")
	public List<UserVo> register(UserVo vo) {
		service.insertUser(vo);
		return service.selectUsers();
	}
	
	@ResponseBody
	@PutMapping("/user/{uid}")
	public List<UserVo> modify(@PathVariable("uid") String uid, UserVo vo) {
		
		vo.setUid(uid);
		
		service.updateUser(vo);
		return service.selectUsers();
	}
	
	@ResponseBody
	@DeleteMapping("/user/{uid}")
	public List<UserVo> delete(@PathVariable("uid") String uid) {
		service.deleteUser(uid);
		return service.selectUsers();
	}
	
	
}
