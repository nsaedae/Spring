package kr.co.sboard1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.sboard1.vo.TermsVo;
import kr.co.sboard1.vo.UserVo;

@Mapper
@Repository
public interface UserDao {

	public void insertUser(UserVo vo);
	public TermsVo selectTerms();
	public UserVo selectUser(UserVo vo);
	public List<UserVo> selectUsers();
	public void updateUser(UserVo vo);
	public void deleteUser(String uid);
	
}
