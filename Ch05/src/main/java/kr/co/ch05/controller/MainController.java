package kr.co.ch05.controller;

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
		String hello = "Hello Thymeleaf";
		
		UserVo user = new UserVo();
		user.setUid("a101");
		user.setName("홍길동");
		user.setHp("010-1234-1111");
		user.setAge(21);
		
		// Spring에서는 컴포넌트간 데이터 공유를 request 사용 권장하지 않음 
		req.setAttribute("title", title);
		
		// Spring에서는 컴포넌트간 데이터 공유를 Model객체 사용 권장
		model.addAttribute("hello", hello);
		model.addAttribute(user);
		
		
		
		return "/index";
	}
	
	
}
