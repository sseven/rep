
package com.ms.framework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.springframework.web.context.ContextLoader;

/**
 * 功能描述：系统安全权限配置单例类
 * @author mao.s
 * 2016年3月12日 下午5:01:07
 */
public class SecurityConfig {
	
	private static final Logger log = Logger.getLogger(SecurityConfig.class);
	private String configFile = "classpath:spring-security.xml";
	private static SecurityConfig config;
	private List<String> resourcesList = new ArrayList<String>();
	private List<String> normalList = new ArrayList<String>();
	/**
	 * 
	 */
	private SecurityConfig() {
		super();
	}
	
	/**
	 * @return
	 */
	public static SecurityConfig instance() {
		if (config == null) {
			config = new SecurityConfig();
			config.initConfig();
		}
		return config;
	}
	
	/**
	 * 判断请求路径是否安全
	 * @param url
	 * @return
	 */
	public boolean isSafe(String url) {
		
		//先判断是否资源文件
		for (String r : resourcesList) {
			if (url.endsWith("." + r)) {
				return true;
			}
		}
		//再判断是否是公共路径
		for (String n : normalList) {
			if (url.startsWith(n)) {
				return true;
			}
		}
		return false;
	}
	
	private void initConfig() {
		//	
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			doc = reader.read(ContextLoader.getCurrentWebApplicationContext().getResource(configFile).getInputStream());
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (doc != null) {
			List<Node> rNodes = doc.selectNodes("/security/resources/r");
			log.info("系统安全权限：资源文件------------------");
			for (Node n : rNodes) {
				log.info(n.getText());
				resourcesList.add(n.getText());
			}
			List<Node> normalNodes = doc.selectNodes("/security/normal/url");
			log.info("系统安全权限：公共路径------------------");
			for (Node n : normalNodes) {
				log.info(n.getText());
				normalList.add(n.getText());
			}
		}
	}
	
}
