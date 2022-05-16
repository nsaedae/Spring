package kr.co.kmarket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.CartVo;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.OrderVo;
import kr.co.kmarket.vo.ProductVo;

@Mapper
@Repository
public interface ProductDao {
	
	public ProductVo selectProduct(int pid);
	public List<ProductVo> selectProducts(ProductVo vo);
	public CategoriesVo selectCateTitles(ProductVo vo);

	//장바구니
	public int insertCart(CartVo vo);
	public List<CartVo> selectCarts(String uid);
	public int deleteCart(int[] cids);
	
	//주문
	public int insertOrder(OrderVo vo);
	public void insertOrderDetail(int oid, int pid, int count);
}
