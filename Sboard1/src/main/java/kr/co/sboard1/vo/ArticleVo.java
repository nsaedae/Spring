package kr.co.sboard1.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

@Getter
@Setter
@Entity
@Table(name = "Board_article")
public class ArticleVo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@Column(updatable=false)
	@CreationTimestamp
	private Timestamp rdate;
	
	// 추가필드
	@Transient // 테이블의 컬럼을 해당 엔티티에서 제외하는 어노테이션
	private MultipartFile fname;
	
}
