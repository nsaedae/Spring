package kr.co.kmarket.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.admin.dao.AdminProductDao;
import kr.co.kmarket.admin.vo.Cate1Vo;
import kr.co.kmarket.admin.vo.Cate2Vo;

@Service
public class AdminProductService {
	
	@Autowired
	private AdminProductDao dao;
	
	public List<Cate1Vo> selectCate1() {
		return dao.selectCate1();
	}
	public List<Cate2Vo> selectCate2(int cate1) {
		return dao.selectCate2(cate1);
	}
}
