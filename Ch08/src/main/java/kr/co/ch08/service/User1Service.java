package kr.co.ch08.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.ch08.persistence.User1Repo;
import kr.co.ch08.vo.User1Vo;

@Service
public class User1Service implements UserDetailsService {

	@Autowired
	private User1Repo repo;
	
	public void insertUser(User1Vo vo) {
		
		// 비밀번호 암호화 처리
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		vo.setPass(passwordEncoder.encode(vo.getPass()));
		
		repo.save(vo);
	}
	public User1Vo selectUser(String uid) {
		return repo.findById(uid).get();
	}
	public List<User1Vo> selectUsers() {
		return repo.findAll();
	}
	public void updateUser(User1Vo vo) {
		repo.save(vo);
	}
	public void deleteUser(String uid) {
		repo.deleteById(uid);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User1Vo userVo = repo.findById(username).get();
		
		if(userVo == null) {
			System.out.println("user 없음!");
			throw new UsernameNotFoundException(username);
		}
		
		return User.builder().
				username(userVo.getUid()).
				password(userVo.getPass()).
				roles("USER").
				build();
	}

}
