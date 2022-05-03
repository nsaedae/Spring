package kr.co.kmarket.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.admin.service.AdminProductService;
import kr.co.kmarket.admin.vo.Cate1Vo;

@Controller
public class AdminProductController {

	@Autowired
	private AdminProductService service;
	
	@GetMapping("/admin/product/list")
	public String list() {
		return "/admin/product/list";
	}
	
	@GetMapping("/admin/product/register")
	public String register() {
		return "/admin/product/register";
	}
	
	@ResponseBody
	@GetMapping("/admin/product/cate1")
	public List<Cate1Vo> cate1() {
		return service.selectCate1();
	}
	
	
}
