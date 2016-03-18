package com.ms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * 日志
 * @author maos
 * @created 2014-7-17 下午05:13:36
 */
@Table(name = "F_DIARY")
@Entity
public class Diary extends BaseEntity {
	
	private static final long serialVersionUID = 3030917836269528075L;
	
	@Lob
	@Column(name = "CONTENT", length = 20000)
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
