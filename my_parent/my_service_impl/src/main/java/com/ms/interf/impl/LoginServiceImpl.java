package com.ms.interf.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ms.dao.SysUserDao;
import com.ms.interf.ILoginService;
import com.ms.model.SysUser;
import com.ms.utils.MD5Utils;
import com.ms.utils.Utils;

@Service
public class LoginServiceImpl implements ILoginService {
	
	@Resource
	private SysUserDao userDao;

	public SysUser login(SysUser user) {
		String pw = MD5Utils.md5Encode(user.getPassword());
		List<SysUser> list = userDao.find("SELECT u FROM SysUser u " +
				" WHERE u.username = :username AND u.password = :password"
					, Utils.getParams("username", user.getUsername()
							, "password", pw));
		return list.size() >= 1 ? list.get(0) : null;
	}

}
