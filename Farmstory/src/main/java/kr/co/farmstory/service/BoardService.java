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
	
	public int selectCountTotal(String type) {
		return dao.selectCountTotal(type);
	}
	public ArticleVo selectArticle(int no) {
		return dao.selectArticle(no);
	}
	public List<ArticleVo> selectArticles(String type, int start) {
		return dao.selectArticles(type, start);
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
	
	
	
	public int getLastPageNum(int total){
		
		int lastPageNum = 0;
		
		if(total % 10 == 0) {
			lastPageNum = total / 10;
		}else {
			lastPageNum = total / 10 + 1;
		}
		
		return lastPageNum;
	}
	
	public int getCurrentPage(String pg) {
		
		int currentPage = 1;
		
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		
		return currentPage;
	}
	
	public int getLimitStart(int currentPage) {
		return (currentPage - 1) * 10;
	}
	
	public int getPageStartNum(int total, int start){
		return total - start;
	}
	
	public int[] getPageGroup(int currentPage, int lastPageNum) {
		
		int groupCurrent = (int) Math.ceil(currentPage/10.0);
		int groupStart = (groupCurrent - 1) * 10 + 1; 
		int groupEnd = groupCurrent * 10;
		
		if(groupEnd > lastPageNum) {
			groupEnd = lastPageNum;
		}
		
		int[] groups = {groupStart, groupEnd};
		
		return groups;
	}
	
	
}
