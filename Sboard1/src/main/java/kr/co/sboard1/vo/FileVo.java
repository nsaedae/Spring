package kr.co.sboard1.vo;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FileVo {
	
	private int fid; 
	private int parent; 
	private String oName; 
	private String nName; 
	private int download;
	private String rdate; 
}
