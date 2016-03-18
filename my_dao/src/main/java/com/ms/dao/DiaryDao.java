package com.ms.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ms.model.Diary;
import com.ms.utils.Pager;

@Repository
public class DiaryDao extends GeneralDao<Diary, String> {

	/**
	 * 查询
	 */
	public Pager<Diary> findList(Map<String, Object> params, Pager<Diary> pager) {
		
		String hql = "FROM Diary d WHERE 1=1";
		if(params.containsKey("creator")) {
			hql += " AND d.creator = :creator";
		}
		String chql = "SELECT count(d.id) " + hql;
		hql = "SELECT d " + hql + " ORDER BY d.createDate DESC";
		return findByPager(hql, chql, params, pager);
	}
	
}

