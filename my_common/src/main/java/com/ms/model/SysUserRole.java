package com.ms.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 用户角色中间表
 * @author maos
 * @created 2014-7-7 下午05:45:29
 */
@Entity
@Table (name = "SYS_USER_ROLE")
public class SysUserRole extends BaseEntity {

	private static final long serialVersionUID = 457718198718667206L;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private SysRole sysRole;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private SysUser sysUser;

	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}



}
