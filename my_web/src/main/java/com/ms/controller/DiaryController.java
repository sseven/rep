package com.ms.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ms.interf.IDiaryService;
import com.ms.model.Diary;



@Controller
@RequestMapping(value = "/diary")
public class DiaryController extends BaseController {
	
	@Resource
	private IDiaryService diaryService;
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, HttpServletResponse response) {

		return "/diary/edit"; 
	}
	
	@RequestMapping("saveDiary")
	public String saveDiary(HttpServletRequest request) {
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		Diary d = new Diary();
		d.setCreateDate(new Date());
		d.setCreator(getUser().getId());
		d.setName(title);
		d.setContent(content);
		diaryService.saveOrUpdate(d);
		return "redirect:/index";
	}
	
	@RequestMapping("detail")
	public String detail(HttpServletRequest request) {
		String did = request.getParameter("did");
		Diary d = diaryService.load(did);
		request.setAttribute("diary", d);
		return "/diary/detail";
	}
	
}
