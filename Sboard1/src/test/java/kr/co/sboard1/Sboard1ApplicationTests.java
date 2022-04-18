package kr.co.sboard1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.sboard1.persistence.UserRepo;

@SpringBootTest
class Sboard1ApplicationTests {
	
	@Autowired
	private UserRepo repo;
	
	
	
	void contextLoads() {
		System.out.println("Hello JUnit!");
	}
	
	
	
	@Test
	public void testCountUser() {
		int result = repo.countUserVoByUid("test22131");
		System.out.println("result : "+result);
	}
	
	
	
}
