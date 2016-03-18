package com.ms.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping(value = "/")
public class UploadController extends BaseController {

	@RequestMapping(value = "upload")
	public String upload(HttpServletRequest request) throws IOException {
		// , @RequestParam MultipartFile[] dir
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
		List<MultipartFile> ufs = mr.getFiles("imgFile");
		for (MultipartFile mf : ufs) {
			if (!mf.isEmpty()) {
				String realSaveDir = buildRealPath(request);
				File d = new File(realSaveDir);
				if (d.exists()) {
					d.mkdirs();
				}
				File f = new File(realSaveDir, mf.getOriginalFilename());
				System.out.println("上传至: " + f.getAbsolutePath());
				FileUtils.copyInputStreamToFile(mf.getInputStream(), f);
			}
		}
		return "/test/success";

	}

	public String buildRealPath(HttpServletRequest request) {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
		String filePath = "/uploads" + dateformat.format(new Date());
		String realPath = request.getSession().getServletContext().getRealPath(
				"/WEB-INF/upload");
		String realSaveDir = realPath + filePath;
		return realSaveDir;
	}

}
