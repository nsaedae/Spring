package kr.co.sboard1.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.sboard1.vo.UserVo;

@Repository
public interface UserRepo extends JpaRepository<UserVo, String>{
	
	// JPA 쿼리 메서드 작성법
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
		
	// JPA Count 쿼리 메서드	
	public int countUserVoByUid(String uid);
	public int countUserVoByNick(String nick);
	public int countUserVoByEmail(String email);
	
}
