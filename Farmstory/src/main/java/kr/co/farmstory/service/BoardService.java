package kr.co.farmstory.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.farmstory.dao.BoardDao;
import kr.co.farmstory.vo.ArticleVo;
import kr.co.farmstory.vo.FileVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao dao;
	
	public int insertArticle(ArticleVo vo) {
		dao.insertArticle(vo);
		return vo.getNo();
	}
	public void insertFile(FileVo vo) {
		dao.insertFile(vo);
	}
	public ArticleVo selectArticle(int no) {
		return dao.selectArticle(no);
	}
	public List<ArticleVo> selectArticles(String type) {
		return dao.selectArticles(type);
	}
	public void updateArticle(ArticleVo vo) {
		dao.updateArticle(vo);
	}
	public void deleteArticle(int no) {
		dao.deleteArticle(no);
	}
	
	@Value("${spring.servlet.multipart.location}")
	private String uploadDir;
	
	public FileVo fileUpload(MultipartFile fname) {
		
		String path = new File(uploadDir).getAbsolutePath();
		
		String oName = fname.getOriginalFilename();
		String ext = oName.substring(oName.lastIndexOf("."));
		
		String nName = UUID.randomUUID().toString()+ext;
		
		FileVo fvo = null;
		
		try {
			// 첨부파일 저장
			fname.transferTo(new File(path+"/"+nName));
			
			// 첨부파일 정보객체 생성
			fvo = new FileVo();
			fvo.setOName(oName);
			fvo.setNName(nName);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return fvo;
	}
	
}
