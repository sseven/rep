package com.ms.constant;

/**
 * 常量
 * @author maos
 * @created 2014-7-21 下午04:26:12
 */
public class Constants {

	// 资源根目录
	public static String ROOT_PATH = "/";
	static {
		String path = Thread.currentThread().getContextClassLoader()
				.getResource("").getPath();
		String secendPath = path.substring(1, path.lastIndexOf("/") - 1);
		secendPath = secendPath.substring(0, secendPath.lastIndexOf("/"));
		ROOT_PATH = secendPath.substring(0, secendPath.lastIndexOf("/")) + "/";
	}
	// 文件上传目录
	public static String FILE_UPLOAD_PATH = "uploads/";
	// 编辑器目录
	public static String EDITOR_FILE_UPLOAD_PATH = "editor/";
	// 普通文件目录
	public static String NORMAL_FILE_UPLOAD_PATH = "normal/";

	
	
	
	
	public static void main(String[] args) {
		System.out.println(ROOT_PATH);
	}
	
}
