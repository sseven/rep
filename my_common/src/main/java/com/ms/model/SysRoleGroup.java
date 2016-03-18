package com.ms.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 角色、角色组中间表
 * @author maos
 * @created 2014-7-7 下午05:29:22
 */
@Entity
@Table (name = "SYS_ROLE_GROUP")
public class SysRoleGroup extends BaseEntity {

	private static final long serialVersionUID = -7921302561881118984L;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private SysGroup group;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private SysRole role;

	public SysRole getRole() {
		return role;
	}

	public void setRole(SysRole role) {
		this.role = role;
	}

	public SysGroup getGroup() {
		return group;
	}

	public void setGroup(SysGroup group) {
		this.group = group;
	}



	
}
