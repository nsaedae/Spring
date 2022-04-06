package kr.co.ch06.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch06.persistence.UserDao;
import kr.co.ch06.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	
	public void insertUser(UserVo vo) {
		dao.insertUser(vo);
	}
	public void selectUser() {
		dao.selectUser();
	}
	public void selectUsers() {
		dao.selectUsers();
	}
	public void updateUser() {
		dao.updateUser();
	}
	public void deleteUser() {
		dao.deleteUser();
	}

}
