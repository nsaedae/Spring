package kr.co.kmarket.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.admin.vo.Cate1Vo;

@Mapper
@Repository
public interface AdminProductDao {
	
	public List<Cate1Vo> selectCate1();

}
