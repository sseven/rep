package com.ms.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.batch.item.util.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping(value = "/")
public class EditorUploadController {

	
	private static SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
	
	private Map<String, Object> getError(String message) {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("error", 1);
		msg.put("message", message);
		return msg;
	}
	
	private String getBasePath(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
		return basePath;
	}
	
	@RequestMapping(value = "editorUpload")
	public void upload(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
		List<MultipartFile> ufs = mr.getFiles("imgFile");
		for (MultipartFile mf : ufs) {
			if (!mf.isEmpty()) {
				/*String relativePath = Constants.FILE_UPLOAD_PATH
						+ Constants.EDITOR_FILE_UPLOAD_PATH
						+ dateformat.format(new Date()) + "/";
				String absolutePath = Constants.ROOT_PATH + relativePath;
				//	System.out.println(absolutePath);
				File d = new File(absolutePath);
				if (d.exists()) {
					d.mkdirs();
				}
				File f = new File(absolutePath, mf.getOriginalFilename());
				// System.out.println("上传至: " + f.getAbsolutePath());
				FileUtils.copyInputStreamToFile(mf.getInputStream(), f);
				//	
				JSONObject obj = new JSONObject();
				obj.put("error", 0);
				obj.put("url", getBasePath(request) + relativePath + mf.getOriginalFilename());
				response.getWriter().write(obj.toString());*/
			}
		}

	}

}
