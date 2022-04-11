package kr.co.ch07.vo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Member")
public class MemberVo {

	@Id
	private String uid;
	private String name;
	private String hp;
	private String pos;
	private String dep;
	private LocalDateTime rdate;
	
	@PrePersist
	public void createAt() {
		this.rdate = LocalDateTime.now();
	}
}
