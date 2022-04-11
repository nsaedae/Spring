package kr.co.ch07.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch07.persistence.MemberRepo;
import kr.co.ch07.persistence.UserRepo;
import kr.co.ch07.vo.MemberVo;
import kr.co.ch07.vo.UserVo;

@Service
public class MemberService {
	@Autowired
	private MemberRepo repo;
	
	public void insertMember(MemberVo vo) {
		repo.save(vo); // Insert ~
	}
	public MemberVo selectMember(String uid) {
		return repo.findById(uid).get();
	}
	public List<MemberVo> selectMembers(){
		return repo.findAll();
	}
	
	public void updateMember(MemberVo vo) {
		repo.save(vo); // Update ~
	}
	public void deleteMember(String uid) {
		repo.deleteById(uid);
	}
}
