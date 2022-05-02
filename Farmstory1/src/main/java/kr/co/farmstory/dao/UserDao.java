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
	public UserVo selectUser(UserVo vo);
	public List<UserVo> selectUsers();
	public int selectCountUserUid(String uid);
	public void updateUser(UserVo vo);
	public void deleteUser(String uid);
	
}
