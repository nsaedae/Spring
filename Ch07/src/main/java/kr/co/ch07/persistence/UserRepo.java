package kr.co.ch07.persistence;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kr.co.ch07.vo.UserVo;


@Repository
public interface UserRepo extends JpaRepository<UserVo, String> {
	
	// JPA 쿼리 메서드 작성
	public List<UserVo> findUserVoByOrderByName();
	public List<UserVo> findUserVoByOrderByAgeAsc();
	public List<UserVo> findUserVoByOrderByAgeDesc();
	
	// JPQL 작성
	@Query("SELECT a FROM UserVo AS a WHERE age < 30")
	public List<UserVo> selectUserUnderAge30(); 
	
}
