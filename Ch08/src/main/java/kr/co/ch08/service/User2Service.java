package kr.co.ch08.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch08.dao.User2Dao;
import kr.co.ch08.vo.User2Vo;

@Service
public class User2Service {
	
	@Autowired
	private User2Dao dao;
	
	public void insertUser(User2Vo vo) {
		dao.insertUser(vo);
	}
	public User2Vo selectUser(User2Vo vo) {
		return dao.selectUser(vo);
	}
	public List<User2Vo> selectUsers() {
		return dao.selectUsers();
	}
	public void updateUser(User2Vo vo) {
		dao.updateUser(vo);
	}
	public void deleteUser(String uid) {
		dao.deleteUser(uid);
	}
}
