package com.ms.interf;

import com.ms.model.SysUser;

public interface ILoginService {

	/**
	 * 登录
	 */	
	public SysUser login(SysUser user);
	
}
