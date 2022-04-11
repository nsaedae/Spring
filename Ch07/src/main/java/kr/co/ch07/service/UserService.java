package kr.co.ch07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch07.persistence.UserRepo;
import kr.co.ch07.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserRepo repo;
	
	public void insertUser(UserVo vo) {
		repo.save(vo);
	}
	public UserVo selectUser(String uid) {
		return null;
	}
	public List<UserVo> selectUsers(){
		return null;
	}
	public void updateUser(UserVo vo) {
	}
	public void deleteUser() {
	}
}
