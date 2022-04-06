package kr.co.ch06.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ch06.vo.UserVo;

@Repository
public interface UserDao {
	public void insertUser(UserVo vo);
	public void selectUser();
	public List<UserVo> selectUsers();
	public void updateUser();
	public void deleteUser();
}
