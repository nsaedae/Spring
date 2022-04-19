package kr.co.sboard1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.sboard1.dao.ArticleDao;
import kr.co.sboard1.persistence.ArticleRepo;
import kr.co.sboard1.persistence.UserRepo;
import kr.co.sboard1.vo.ArticleVo;

@SpringBootTest
class Sboard1ApplicationTests {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ArticleRepo articleRepo;
	
	@Autowired
	private ArticleDao articleDao;
	
	
	void contextLoads() {
		System.out.println("Hello JUnit!");
	}
	
	public void testCountUser() {
		int result = userRepo.countUserVoByUid("test22131");
		System.out.println("result : "+result);
	}
	
	@Test
	public void testArticleInsert() {
		
		ArticleVo vo = new ArticleVo();
		vo.setTitle("테스트 제목 입니다.112");
		vo.setContent("테스트 내용 입니다.112");
		vo.setUid("test");
		vo.setRegip("128.0.0.1");
		
		// JPA
		articleRepo.save(vo);
		
		// MyBatis
		//dao.insertArticle(vo);
		
		// 방금 Insert한 글번호 리턴(JPA, MyBatis)
		int no = vo.getNo();
		
		System.out.println("글번호 : "+no);
	}
	
	
	
}
