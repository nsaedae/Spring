package kr.co.ch05.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ch05.vo.UserVo;

@Controller
public class MainController {

	@GetMapping(value={"/", "/index"})
	public String index(HttpServletRequest req, Model model) {
		
		String title = "Spring Thymeleaf 실습";
		String hello = "Hello Thymeleaf!";
		
		UserVo user1 = new UserVo();
		user1.setUid("a100");
		user1.setName("홍길동");
		user1.setHp("010-1234-1111");
		user1.setAge(19);
		
		UserVo user2 = null;
		
		List<UserVo> users = new ArrayList<>();
		users.add(new UserVo("a101", "김유신", "010-1234-1001", 23));
		users.add(new UserVo("a102", "김춘추", "010-1234-1002", 21));
		users.add(new UserVo("a103", "장보고", "010-1234-1003", 31));
		users.add(new UserVo("a104", "강감찬", "010-1234-1004", 42));
		users.add(new UserVo("a105", "이순신", "010-1234-1005", 50));
		
		
		// Spring에서는 컴포넌트간 데이터 공유를 request 사용 권장하지 않음 
		req.setAttribute("title", title);
		
		// Spring에서는 컴포넌트간 데이터 공유를 Model객체 사용 권장
		model.addAttribute("hello", hello);
		model.addAttribute("user1", user1);
		model.addAttribute("user2", user2);
		model.addAttribute("users", users);
		
		return "/index";
	}
	
	
	@GetMapping("/include")
	public String include() {
		return "/include";
	}
	
	
	
}
