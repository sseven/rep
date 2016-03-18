package com.ms.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ms.constant.SessionConstantKey;
import com.ms.model.SysUser;


public class BaseController {
	
	public Logger log = Logger.getLogger(this.getClass());

	/**
	 * 
	 * @param verifyCode
	 * @return
	 */
	public static boolean isVerifyPassed(String verifyCode) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		String vc = ((String)session.getAttribute("verify"));
		return vc != null && vc.equals(verifyCode != null ? verifyCode.toLowerCase() : "");
	}
	
	/**
	 * 获取当前登录用户
	 */
	protected SysUser getUser() {
		if (getAttribute(SessionConstantKey.LOGIN_USER.toString())!=null) {
			return (SysUser)getAttribute(SessionConstantKey.LOGIN_USER);
		}
		return null;
	}
	
	/**
	 * 获取Request对象
	 */
	protected HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 获取Response对象
	 */
	protected HttpServletResponse getResponse() {
		return  ((ServletWebRequest) RequestContextHolder.getRequestAttributes()).getResponse(); 
	}

	/**
	 * 获取Session对象
	 */
	protected HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * 保存session值
	 */
	protected void setAttribute(String key, Object value) {
		getSession().setAttribute(key, value);
	}

	/**
	 * 移除session值
	 */
	protected void removeAttribute(String key) {
		getSession().removeAttribute(key);
	}

	/**
	 * 获取session值
	 */
	protected Object getAttribute(String key) {
		return getSession().getAttribute(key);
	}
	
	/**
	 * 根据参数名组获取对应值
	 * @param keys
	 * @return
	 */
	public Map<String, Object> loadRequestParams(String ... keys) {
		Map<String, Object> params = new HashMap<String, Object>();
		for(String k : keys) {
			if(getRequest().getParameterMap().containsKey(k) && !StringUtils.isEmpty(getRequest().getParameter(k)))
				params.put(k, getRequest().getParameter(k));
		}
		return params;
	}
	
	public Map<String, Object> getAllParameters() {
		Map<String, Object> params = new HashMap<String, Object>();
		Enumeration<String> es = getRequest().getParameterNames();
		while(es.hasMoreElements()) {
			String k = es.nextElement();
			if(getRequest().getParameterMap().containsKey(k) && !StringUtils.isEmpty(getRequest().getParameter(k)))
				params.put(k, getRequest().getParameter(k));
		}
			
		return params;
	}
	
	
	protected String getRequestParam(String key) {
		return getRequest().getParameter(key);
	}
	
	/**
	 * 指定请求参数keys添加至ModelAndView
	 * @param m
	 * @param keys
	 */
	protected void requestParamstersToModelAndView(ModelAndView m, String ... keys) {
		for(String k : keys) {
			if(getRequest().getParameterMap().containsKey(k) && !StringUtils.isEmpty(getRequest().getParameter(k)))
				m.addObject(k, getRequest().getParameter(k));
		}
	}
	
	
	public void write(String content, HttpServletResponse response) {
		//	
		String charset = "UTF-8";
		response.setCharacterEncoding(charset==null?"UTF-8":charset);
		response.setContentType("text/html;charset="+charset);
		try {
			response.setCharacterEncoding(charset==null?"UTF-8":charset);
			response.setContentType("text/html;charset="+charset);
			response.getWriter().print(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	/**
	 * 获取IP
	 * @param request
	 * @return
	 */
	public String getIpAddress(HttpServletRequest request) {
		
	    String ip = request.getHeader("x-forwarded-for"); 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("WL-Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_CLIENT_IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getRemoteAddr(); 
	    } 
	    return ip; 
	} 
}
