package com.ms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 用户表
 * @author maos
 * @created 2014-7-4 下午04:18:27
 */
@Entity
@Table (name = "SYS_USER")
public class SysUser extends BaseEntity {

	private static final long serialVersionUID = -4024866676926313925L;
	
	@Column(name = "USERNAME", length = 100, nullable = false)
	private String username;
	
	@Column(name = "PASSWORD", length = 100, nullable = false)
	private String password;
	
	@Column(name = "NICKNAME", length = 100, nullable = false)
	private String nickname;
	
	@Column(name = "LOGIN_COUNT")
	private int loginCount;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_LOGIN", length = 19)
	private Date lastLogin;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	
}
