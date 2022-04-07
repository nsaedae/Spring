package kr.co.ch06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch06.service.CustomerService;
import kr.co.ch06.vo.CustomerVo;
import kr.co.ch06.vo.UserVo;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@GetMapping("/customer/register")
	public String register() {
		return "/customer/register";
	}
	
	@PostMapping("/customer/register")
	public String register(CustomerVo vo) {
		// 등록요청
		service.insertCustomer(vo);
		return "redirect:/customer/register";
	}
	
	@GetMapping("/customer/list")
	public String list(Model model) {
		
		// 데이터요청
		List<CustomerVo> customers = service.selectCustomers();
		model.addAttribute("customers", customers);
		
		return "/customer/list";
	}
	
	@GetMapping("/customer/modify")
	public String modify(int custid, Model model) {
		// 수정 데이터요청
		CustomerVo customer = service.selectCustomer(custid);
		model.addAttribute("customer", customer);
		
		return "/customer/modify";
	}
	
	@PostMapping("/customer/modify")
	public String modify(CustomerVo vo) {
		
		// 수정요청
		service.updateCustomer(vo);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/customer/delete")
	public String delete(int custid) {
		// 삭제요청
		service.deleteCustomer(custid);
		
		return "redirect:/customer/list";
	}
	
}
