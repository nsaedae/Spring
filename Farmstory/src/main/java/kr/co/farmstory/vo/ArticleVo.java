package kr.co.farmstory.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleVo {
	
	private int no;
	private int parent;
	private int comment;
	private String type;
	private String title;
	private String content;
	private int file;
	private int hit;
	private String uid;
	private String regip;
	private String rdate;
	
	
	// 추가필드
	private String cate;
	private MultipartFile fname;
	private String nick;
		
	private FileVo fvo;

}
