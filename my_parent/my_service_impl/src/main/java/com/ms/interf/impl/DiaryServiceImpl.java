package com.ms.interf.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.dao.DiaryDao;
import com.ms.interf.IDiaryService;
import com.ms.model.Diary;
import com.ms.utils.Pager;

@Service
public class DiaryServiceImpl implements IDiaryService {

	@Resource
	private DiaryDao diaryDao;
	
	@Transactional
	@Override
	public Diary saveOrUpdate(Diary d) {
		diaryDao.saveOrUpdate(d);
		return d;
	}

	@Override
	public Diary load(String id) {
		return diaryDao.load(id);
	}

	@Override
	public Diary get(String id) {
		return diaryDao.get(id);
	}

	@Override
	public Pager<Diary> findList(Map<String, Object> params, Pager<Diary> pager) {
		return diaryDao.findList(params, pager);
	}

}
