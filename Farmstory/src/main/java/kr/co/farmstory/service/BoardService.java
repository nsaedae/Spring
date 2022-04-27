package kr.co.farmstory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.farmstory.dao.BoardDao;
import kr.co.farmstory.vo.ArticleVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao dao;
	
	public void insertArticle(ArticleVo vo) {
		dao.insertArticle(vo);
	}
	public ArticleVo selectArticle(int no) {
		return dao.selectArticle(no);
	}
	public List<ArticleVo> selectArticles() {
		return dao.selectArticles();
	}
	public void updateArticle(ArticleVo vo) {
		dao.updateArticle(vo);
	}
	public void deleteArticle(int no) {
		dao.deleteArticle(no);
	}
}
