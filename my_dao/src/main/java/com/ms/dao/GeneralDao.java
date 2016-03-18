package com.ms.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ms.utils.Pager;

/**
 * 增强版DAO
 * @author mao.s
 * 2016年3月15日 下午4:24:11
 */
public class GeneralDao<T, ID extends Serializable> extends BaseDao<T, Serializable>{

	
	/**
	 * 分页查询
	 * @param hql	返回数据
	 * @param chql	返回记录条数
	 * @param params	命名参数
	 * @param pager		分页器
	 */
	public Pager<T> findByPager(String hql, String chql ,Map<String, Object> params, Pager<T> pager) {
		
		//	数据集
		List<T> rs = null;
		//	符合条件的记录条数
		Integer totalRows = 0;
		//	
		rs = find(hql, params, pager.getTargetPage(), pager.getPageSize());
		totalRows = count(chql, params).intValue();
		//	
		pager.setData(rs);
		pager.setTotalRows(totalRows);
		pager.setCurrentPage(pager.getTargetPage());
		
		return pager;
		
	}
	
}
