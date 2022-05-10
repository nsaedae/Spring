package kr.co.kmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket.service.ProductService;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.ProductVo;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	
	@GetMapping("/product/cart")
	public String cart() {
		return "/product/cart";
	}
	@GetMapping("/product/complete")
	public String complete() {
		return "/product/complete";
	}
	
	@GetMapping("/product/list")
	public String list(ProductVo vo, Model model) {
		
		int start = 0;
		int order = vo.getOrder();
		
		vo.setStart(start);
		vo.setOrder(order);
				
		CategoriesVo cates = service.selectCateTitles(vo);		
		List<ProductVo> products = service.selectProducts(vo);
		
		model.addAttribute("products", products);
		model.addAttribute("cates", cates);
		model.addAttribute("order", order);
		
		
		return "/product/list";
	}
	
	@GetMapping("/product/view")
	public String view(int pid, Model model) {
		
		ProductVo product = service.selectProduct(pid);
		CategoriesVo cates = service.selectCateTitles(product);
		
		model.addAttribute("product", product);
		model.addAttribute("cates", cates);
		
		return "/product/view";
	}
	@GetMapping("/product/order")
	public String order() {
		return "/product/order";
	}
	@GetMapping("/product/search")
	public String search() {
		return "/product/search";
	}
	
	
}
