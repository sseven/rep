package com.ms.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 * 
 * @author maos
 * @created 2014-7-8 上午09:56:46
 */
public class MD5Utils {
	
	
	public static void main(String[] args) {
		System.out.println(md5Encode("123123"));
		System.out.println(md5Encode("123123"));
	}
	
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", 
		   "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" }; 

	/**
	 * md5
	 */
	public static String md5Encode(String s) {
		return encode("MD5", s);
	}

	/**
	 * 将摘要信息转换为相应的编码
	 * 
	 * @param code
	 *            编码类型
	 * @param message
	 *            摘要信息
	 * @return 相应的编码字符串
	 */
	private static String encode(String code, String message) {
		MessageDigest md;
		String encode = null;
		try {
			md = MessageDigest.getInstance(code);
			encode = byteArrayToHexString(md.digest(message.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encode;
	}

	/**
	 * 将字节数组转换为十六进制字符串
	 */
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	/**
	 * 将字节转换为十六进制字符
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
}
