package kr.co.farmstory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.farmstory.vo.TermsVo;
import kr.co.farmstory.vo.UserVo;

@Mapper
@Repository
public interface UserDao {

	public void insertUser(UserVo vo);
	public TermsVo selectTerms();
	public UserVo selectUser(String uid);
	public List<UserVo> selectUsers();
	public void updateUser(UserVo vo);
	public void deleteUser(String uid);
	
}
