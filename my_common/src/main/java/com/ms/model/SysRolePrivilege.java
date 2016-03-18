package com.ms.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 角色权限中间表
 * @author maos
 * @created 2014-7-7 下午05:51:36
 */
@Entity
@Table (name = "SYS_ROLE_PRIVILEGE")
public class SysRolePrivilege extends BaseEntity {

	private static final long serialVersionUID = 2438385522399138235L;

	@ManyToOne(fetch = FetchType.EAGER)
	private SysRole sysRole;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private SysPrivilege sysPrivilege;

	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public SysPrivilege getSysPrivilege() {
		return sysPrivilege;
	}

	public void setSysPrivilege(SysPrivilege sysPrivilege) {
		this.sysPrivilege = sysPrivilege;
	}

	
}
