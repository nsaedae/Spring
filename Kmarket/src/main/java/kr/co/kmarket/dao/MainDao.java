package kr.co.kmarket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.CategoriesVo;

@Mapper
@Repository
public interface MainDao {
	
	public List<CategoriesVo> selectCategories();

	
}
