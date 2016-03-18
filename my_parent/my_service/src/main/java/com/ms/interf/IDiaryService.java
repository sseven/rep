package com.ms.interf;

import java.util.Map;

import com.ms.model.Diary;
import com.ms.utils.Pager;


public interface IDiaryService {
	
	
	public Diary load(String id);
	
	public Diary get(String id);

	public Diary saveOrUpdate(Diary d);
	
	public Pager<Diary> findList(Map<String, Object> params, Pager<Diary> pager);
	
	
	
}
