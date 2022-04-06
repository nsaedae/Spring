package kr.co.ch06.persistence;

import org.springframework.stereotype.Repository;

import kr.co.ch06.vo.UserVo;

@Repository
public interface UserDao {
	public void insertUser(UserVo vo);
	public void selectUser();
	public void selectUsers();
	public void updateUser();
	public void deleteUser();
}
