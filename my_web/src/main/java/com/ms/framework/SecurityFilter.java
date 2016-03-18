package com.ms.framework;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ms.constant.SessionConstantKey;

/**
 * 功能描述：系统权限、静态资源过滤
 * @author mao.s
 * 2016年3月12日 下午4:45:11
 */
public class SecurityFilter implements Filter {
	
	private static Logger logger = Logger.getLogger(SecurityFilter.class);


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		ServletContext servletContext = filterConfig.getServletContext();
		WebApplicationContext wac = null;
		wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		
	}
	
	private boolean isLogin(HttpServletRequest req) {
		return req.getSession().getAttribute(SessionConstantKey.LOGIN_USER) != null;
	}
	

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//	如果是资源文件，直接通过
		if (SecurityConfig.instance().isSafe(request.getServletPath())) {
		}else {
			//	System.out.println(request.getServletPath() + " > 处理....");
			//	验证登录
			if(isLogin(request)) {
				
			}else {
				response.sendRedirect(request.getContextPath() + "/login");
				return;
			}
		}
		chain.doFilter(req, res);
	}


	public void destroy() {

	}

}
