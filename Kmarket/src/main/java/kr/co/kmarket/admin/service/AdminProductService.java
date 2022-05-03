package kr.co.kmarket.admin.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.kmarket.admin.dao.AdminProductDao;
import kr.co.kmarket.admin.vo.Cate1Vo;
import kr.co.kmarket.admin.vo.Cate2Vo;
import kr.co.kmarket.admin.vo.ProductVo;

@Service
public class AdminProductService {
	
	@Autowired
	private AdminProductDao dao;
	
	public List<Cate1Vo> selectCate1() {
		return dao.selectCate1();
	}
	public List<Cate2Vo> selectCate2(int cate1) {
		return dao.selectCate2(cate1);
	}
	
	public void insertProduct(ProductVo vo) {
		dao.insertProduct(vo);
	}
	
	
	@Value("${spring.servlet.multipart.location}")
	private String uploadDir;
	
	public ProductVo uploadThumbnail(ProductVo vo) {
		
		// 경로 생성
		String path = new File(uploadDir).getAbsolutePath();
		String fullPath = path+"/"+vo.getCate1()+"/"+vo.getCate2()+"/";
		
		int i = 0;
		for(MultipartFile mf : vo.getThumbnails()) {
			
			if(!mf.isEmpty()) {
				// 파일 확장자 + UUID명 생성
				String name = mf.getOriginalFilename();
				String ext = name.substring(name.lastIndexOf("."));
				String uName = UUID.randomUUID().toString()+ext;
				
				try {
					// 디렉터리 생성
					Path root = Paths.get(fullPath);
					Files.createDirectories(root);
					
					// 썸네일 이미지 저장
					File file = new File(fullPath+uName);
					mf.transferTo(file);
					
					// UUID 파일명 vo저장
					if(i==0) vo.setThumb1(uName);
					if(i==1) vo.setThumb2(uName);
					if(i==2) vo.setThumb3(uName);
					if(i==3) vo.setDetail(uName);
					
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			
			} // end if
			
			i++;
			
		}// end for
		
		return vo;
	}// end uploadThumbnail
	
	
}
