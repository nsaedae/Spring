package kr.co.ch08.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.ch08.persistence.UserRepo;
import kr.co.ch08.vo.UserVo;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	
	public void insertUser(UserVo vo) {
		
		// 비밀번호 암호화 처리
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		vo.setPass(passwordEncoder.encode(vo.getPass()));
		
		repo.save(vo);
	}
	public UserVo selectUser(String uid) {
		return repo.findById(uid).get();
	}
	public List<UserVo> selectUsers() {
		return repo.findAll();
	}
	public void updateUser(UserVo vo) {
		repo.save(vo);
	}
	public void deleteUser(String uid) {
		repo.deleteById(uid);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserVo userVo = repo.findById(username).get();
		
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
