package kr.co.ch08.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.ch08.vo.User2Vo;

@Mapper
@Repository
public interface User2Dao {

	public void insertUser(User2Vo vo);
	// 로그인용
	public User2Vo selectUser(User2Vo vo);
	// 조회용
	public User2Vo selectUser(String uid);
	public List<User2Vo> selectUsers();
	public void updateUser(User2Vo vo);
	public void deleteUser(String uid);
	
}
