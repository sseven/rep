package com.ms.utils;

import java.awt.FontMetrics;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;

import org.apache.commons.lang.StringUtils;



/**
 * 
 * @author maos
 * @created 2014-1-4
 */
public class Utils {
	
	
	/**
	 * 将逗号隔开的id(1,2)加上可用in查询的ID（'1','2'）
	 * @param ids
	 * @return
	 */
	public static String converIds(String ids) {
		if(org.apache.commons.lang.StringUtils.isNotEmpty(ids)) {
			String[] dids = ids.split(",");
			String fids = "";
			for (String string : dids) {
				fids += "'" + string + "',";
			}
			return fids.substring(0, fids.length() - 1);
		}
		return null;
	}
	
	
	/**
	 * 设置消息编码
	 * @param message
	 * @param enc
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String encode(String message, String enc) {
		if (!StringUtils.isBlank(message)) {
			try {
				message = URLEncoder.encode(URLEncoder.encode(message, enc), enc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return message;
	}

	/**
	 * 消息解码
	 * @param message
	 * @param enc
	 * @return
	 */
	public static String decode(String message, String enc) {
		if (!StringUtils.isBlank(message)) {
			try {
				message = URLDecoder.decode(URLDecoder.decode(message, enc), enc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return message;
	}
	
	/**
	 * 数字处理
	 */
	public static class DecimalProcess {
		
		public static DecimalFormat df2 = new DecimalFormat("####.000");
		public static NumberFormat pf = NumberFormat.getPercentInstance();
		
		static {
			pf.setMinimumFractionDigits(1);
		}
	}

	
	/**
	 * 对象是否为null或者""
	 */
	public static boolean isEmpty(Object o) {
		return o == null || o.toString().length() == 0;
	}
	
	public static boolean isTrimToEmpty(Object o) {
		return o == null || o.toString().trim().length() == 0;
	}
	
	/**
	 * 获取枚举所有项
	 */
	public static Map<String, Object> enumNameValues (Enum[] es) {
		Map<String, Object> rs = new HashMap<String, Object>();
		for (Enum e : es) {
			rs.put(e.name(), EnumUtils.desc(e));
		}
		return rs;
	}
	
	/**
	 * 两个字符串是否相同
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isEquals(String s1, String s2) {
		if(s1 == s2) {
			return true;
		}
		if(s1 != null && s2 != null && s1.equals(s2)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 装载Map
	 * @param ss
	 * @return
	 */
	public static Map<String, Object> getParams(Object... ss) {
		Map<String, Object> ps = new HashMap<String, Object>();
		for (int i = 0; i < ss.length; i++) {
			ps.put(ss[i].toString(), ss[++i]);
		}
		return ps;
	}

}
