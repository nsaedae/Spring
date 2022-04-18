package kr.co.sboard1.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.sboard1.vo.ArticleVo;
import kr.co.sboard1.vo.UserVo;

@Repository
public interface ArticleRepo extends JpaRepository<ArticleVo, Integer>{
	
}
