package kr.co.kmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.ProductDao;
import kr.co.kmarket.vo.CartVo;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.OrderVo;
import kr.co.kmarket.vo.ProductVo;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;
	
	public ProductVo selectProduct(int pid) {
		return dao.selectProduct(pid);
	}
	
	public List<ProductVo> selectProducts(ProductVo vo){
		return dao.selectProducts(vo);
	}
	
	public CategoriesVo selectCateTitles(ProductVo vo) {
		return dao.selectCateTitles(vo);
	}
	
	public int insertCart(CartVo vo) {
		return dao.insertCart(vo);
	}
	
	public List<CartVo> selectCarts(String uid){
		return dao.selectCarts(uid);
	}
	
	public int deleteCart(int[] cids) {
		return dao.deleteCart(cids);
	}
	
	public int insertOrder(OrderVo vo) {
		dao.insertOrder(vo);
		return vo.getOid();
	}
	
	public void insertOrderDetail(int oid, int pid, int count) {
		dao.insertOrderDetail(oid, pid, count);
	}
	
	public List<OrderVo> selectOrders(int oid){
		return dao.selectOrders(oid);
	}
	
	public int updateOrder(OrderVo vo) {
		return dao.updateOrder(vo);
	}
}
