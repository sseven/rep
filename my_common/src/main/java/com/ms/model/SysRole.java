package com.ms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 角色
 * @author maos
 * @created 2014-7-7 下午05:25:38
 */
@Entity
@Table (name = "SYS_ROLE")
public class SysRole extends BaseEntity {

	
	private static final long serialVersionUID = -5828203803471759872L;
	
	//	描述	
	@Column(name = "REMARK", length = 500, nullable = true)
	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
