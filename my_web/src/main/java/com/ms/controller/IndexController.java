package com.ms.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ms.constant.Constants;
import com.ms.interf.IDiaryService;
import com.ms.interf.ILoginService;
import com.ms.model.Diary;
import com.ms.model.SysUser;
import com.ms.utils.Pager;
import com.ms.utils.Utils;
import com.ms.utils.date.DateUtil;

/**
 * 首页
 * @author maos
 * @created 2014-7-11 上午09:45:19
 */
@Controller
@RequestMapping(value = "/")
public class IndexController extends BaseController {
	
	@Resource
	private ILoginService loginService;
	@Resource
	private IDiaryService diaryService;
	
	@RequestMapping("home")
	public ModelAndView index(HttpServletRequest request, SysUser user) {
		ModelAndView m = new ModelAndView();
		m.setViewName("../home");
		return m;
	}
	
	/**
	 * 获取日志记录
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/diaries")
	public void diaries(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int currentIndex = Integer.parseInt(request.getParameter("currentIndex"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		Pager<Diary> pager = diaryService.findList(Utils.getParams("creator", getUser().getId())
				, new Pager<Diary>(currentIndex, pageSize));
		//	Thread.currentThread().sleep(1500);
		JSONArray jas = new JSONArray();
		for (Diary diary : pager.getData()) {
			JSONObject o = new JSONObject();
			o.put("id", diary.getId());
			o.put("name", diary.getName());
			o.put("creator", diary.getCreator());
			o.put("content", diary.getContent());
			o.put("createDate", DateUtil.dateToStr(diary.getCreateDate()));
			o.put("firstImage", getFirstImageUrl(diary.getContent()));
			jas.add(o);
		}
		JSONObject jo = new JSONObject();
		jo.put("data", jas.toString());
		jo.put("totalCount", pager.getTotalRows());
		response.setHeader("content-type","text/html;charset=UTF-8"); 
		response.getWriter().write(jo.toString() );
	}
	
	
	public String getShortContent(String content) {
		content = content.replaceAll("\\&[a-zA-Z]{0,9};", "").replaceAll("<[^>]*>", "\n\t");
		return content != null && content.length() >= 450 ? content : content;
	}
	
	public String getFirstImageUrl(String content) {

		Pattern p = Pattern.compile("<img[\\s\\S]*?src=\"([\\s\\S]*?)\"[\\s\\S]*?(^<*?></img>|/>|>)");
		Matcher m = p.matcher(content);
		if(m.find()) {
			return m.group(1);
		}
		return "";
	}
	
	public String[] urls = new String[]{
			"<img href=\"http://img1.chinagba.com/medias/userup/1311/20095Z2Q92_lit.jpg\"></img>",
			"<img href=\"http://c.hiphotos.baidu.com/image/pic/item/0df431adcbef7609e10564922cdda3cc7cd99eb5.jpg\"></img>",
			"<img href=\"http://e.hiphotos.baidu.com/image/pic/item/472309f790529822069fc4ced5ca7bcb0a46d40b.jpg\"></img>",
			"<img href=\"http://d.hiphotos.baidu.com/image/pic/item/a2cc7cd98d1001e98a41e702ba0e7bec54e797ba.jpg\"></img>",
			"<img href=\"http://b.hiphotos.baidu.com/image/pic/item/32fa828ba61ea8d3143e8609950a304e251f589b.jpg\"></img>",
			"<img href=\"http://g.hiphotos.baidu.com/image/pic/item/a8014c086e061d955c00ca3579f40ad162d9ca7d.jpg\"></img>",
			"<img href=\"http://c.hiphotos.baidu.com/image/pic/item/e4dde71190ef76c665fd09269f16fdfaaf516794.jpg\"></img>",
			"<img href=\"http://f.hiphotos.baidu.com/image/pic/item/e1fe9925bc315c60e17b9ae28fb1cb13485477d5.jpg\"></img>"
			
	};
	
	public static void main(String[] args) {
		String content = "<img  src=\"http://b60ff8b41f368739.qusu.org/uploads/allimg/140721/1807110.jpg?qsv=78&web_real_domain=www.cnwnews.com\"/>";
		Pattern p = Pattern.compile("<img[\\s\\S]*?src=\"([\\s\\S]*?)\"[\\s\\S]*?(^<*?></img>|/>|>)");
		Matcher m = p.matcher(content);
		if(m.find()) {
			System.out.println(m.group(1));
		}
	}
	
}
