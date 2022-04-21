package kr.co.sboard1.service;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.sboard1.dao.ArticleDao;
import kr.co.sboard1.persistence.ArticleRepo;
import kr.co.sboard1.persistence.FileRepo;
import kr.co.sboard1.vo.ArticleVo;
import kr.co.sboard1.vo.FileVo;

@Service
public class ArticleService {

	@Autowired
	private ArticleDao dao;
	
	@Autowired
	private ArticleRepo repo;
	
	@Autowired
	private FileRepo fileRepo;
	
	public int insertArticle(ArticleVo vo) {
		// JPA
		//repo.save(vo);
		// MyBatis
		dao.insertArticle(vo);
		return vo.getNo();
	}
	
	public void insertFile(FileVo vo) {
		// JPA
		//fileRepo.save(vo);
		
		// MyBatis
		dao.insertFile(vo);
	}
	
	public int insertComment(ArticleVo vo) {
		return dao.insertComment(vo);
	}
	
	public List<ArticleVo> selectComments(int no){
		return dao.selectComments(no);
	}
	
	public ArticleVo selectArticle(int no) {
		
		// JPA
		
		// MyBatis
		ArticleVo article = dao.selectArticle(no);
		
		return article;
	}
	
	public List<ArticleVo> selectArticles(int start){
		
		// JPA
		
		
		// MyBatis
		List<ArticleVo> articles = dao.selectArticles(start);
		
		return articles;
	}
	
	public int selectCountTotal() {
		// JPA
		// MyBatis
		int total = dao.selectCountTotal();
		return total;
	}
	
	public FileVo selectFile(int fid) {
		
		// JPA
		// MyBatis
		FileVo fvo = dao.selectFile(fid);
		
		return fvo;
	}
	
	public void updateArticle(ArticleVo vo) {}
	public void deleteArticle(int no) {}

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
	
	public void fileDownload(HttpServletResponse resp, FileVo fvo) {
		
		try {
			// 파일 다운로드 response 헤더수정	
			resp.setContentType("application/octet-stream");
			resp.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fvo.getOName(), "utf-8"));
			resp.setHeader("Content-Transfer-Encoding", "binary");
			resp.setHeader("Pragma", "no-cache");
			resp.setHeader("Cache-Control", "private");
			
			// 파일 스트림 작업
			String path = new File(uploadDir).getAbsolutePath()+"/"+fvo.getNName();
			byte[] fileByte = FileUtils.readFileToByteArray(new File(path));		
			
			resp.getOutputStream().write(fileByte);
			resp.getOutputStream().flush();
			resp.getOutputStream().close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
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
