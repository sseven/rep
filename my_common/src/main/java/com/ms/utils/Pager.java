package com.ms.utils;

import java.util.List;


/**
 * 分页bean
 * @author maos
 * @date   2014-4-15
 */
public class Pager<T> implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7030868289717770265L;
	
	
	//	当前页数
	private int currentPage;
	//	目标页数
	private int targetPage = 1;
	//	每页记录条数(default = 10)
	private int pageSize = 10;
	//	总记录条数
	private int totalRows;
	//	总页数
	private int totalPage;
	//	数据集
	private List<T> data;
	
	//	重新整理下数据
	public void tidy() {
		int tp = 0;
		if(totalPage == 0) {
			tp = (totalRows / pageSize) + ((totalRows % pageSize >= 1) ? 1 : 0);
			this.totalPage = tp;
		}
		if(totalPage == 0) {
			currentPage = 0;
		}else {
			this.currentPage = targetPage;
		}
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTargetPage() {
		return targetPage;
	}
	public void setTargetPage(int targetPage) {
		this.targetPage = targetPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public Pager(){}
	public Pager(int totalRows) {
		super();
		this.totalRows = totalRows;
	}
	
	public Pager(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
	
	
}
