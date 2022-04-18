package kr.co.sboard1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sboard1.dao.UserDao;
import kr.co.sboard1.persistence.UserRepo;
import kr.co.sboard1.vo.TermsVo;
import kr.co.sboard1.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	@Autowired
	private UserRepo repo;
	
	public void insertUser(UserVo vo) {
		dao.insertUser(vo);
	}
	
	public TermsVo selectTerms() {
		return dao.selectTerms();
	}
	
	public int countUserUid(String uid) {
		return repo.countUserVoByUid(uid);
	}
	public UserVo selectUser(UserVo vo) {
		return dao.selectUser(vo);
	}
	public List<UserVo> selectUsers(){
		return null;
	}
	public void updateUser(UserVo vo) {}
	public void deleteUser(String uid) {}
}
