package com.ms.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ms.constant.LoginState;
import com.ms.constant.SessionConstantKey;
import com.ms.interf.ILoginService;
import com.ms.model.SysUser;
import com.ms.utils.MD5Utils;
import com.ms.utils.Utils;

/**
 * 登录
 * @author maos
 * @created 2014-7-9 下午05:39:29
 */
@Controller
@RequestMapping(value = "/")
public class LoginController extends BaseController {
	
	@Resource
	private ILoginService loginService;
	
	@RequestMapping("login")
	public ModelAndView login(HttpServletRequest request, SysUser user) {
		
		//	登录页
		ModelAndView m = new ModelAndView();
		m.setViewName("../login_");
		if(Utils.isEmpty(user.getUsername()) && Utils.isEmpty(user.getPassword())) {
			return m;
		}
		//	验证码校验
		if(isVerifyPassed(request.getParameter("verifyCode"))) {
			//	登录失败
			if(user == null || Utils.isTrimToEmpty(user.getUsername()) || Utils.isTrimToEmpty(user.getPassword())) {
				m.addObject("loginState", LoginState.INFO_INVALID);
			}else {
				SysUser loginUser = loginService.login(user);
				if(loginUser == null) {
					m.addObject("loginState", LoginState.INFO_INVALID);
				}else {
					//	登录成功
					//	m.addObject("loginState", LoginState.LOGIN_SUCCESS);
					request.getSession().setAttribute(SessionConstantKey.LOGIN_USER, loginUser);
					m.setViewName("redirect:/home");
				}
			}
		}else {
			if(!Utils.isEmpty(request.getParameter("verifyCode")) || !Utils.isTrimToEmpty(user.getUsername()) || !Utils.isTrimToEmpty(user.getPassword()))
				m.addObject("loginState", LoginState.VIRIFY_CODE_INVALID);
		}
		return m;
	}
	
	
	@RequestMapping("loginout")
	public ModelAndView loginout(HttpServletRequest request) {
		ModelAndView m = new ModelAndView();
		request.getSession().removeAttribute(SessionConstantKey.LOGIN_USER);
		m.setViewName("redirect:/");
		return m;
	}
	
	private void addUser() {
		SysUser user = new SysUser();
		user.setCreateDate(new Date());
		user.setModifyDate(new Date());
		user.setUsername("admin");
		user.setNickname("小然");
		user.setPassword(MD5Utils.md5Encode("admin"));
		//	loginService.save(user);
	}
	
}
