package kr.co.sboard1.vo;

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
	
	public String getRdate() {
		return rdate.toString().substring(2, 10);
	}
	
	// 추가필드
	private MultipartFile fname;
	private String nick;
	private FileVo fvo;
	
	
}
