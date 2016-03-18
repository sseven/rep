package com.ms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 角色组
 * @author maos
 * @created 2014-7-7 下午05:28:21
 */
@Entity
@Table (name = "SYS_GROUP")
public class SysGroup extends BaseEntity{
	
	private static final long serialVersionUID = 2004839014988732601L;
	
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
