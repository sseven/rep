package com.ms.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/** 
 * 基础数据库操作类 
 *  
 * @author maos 
 *  
 */  
public interface IBaseDao <T, ID extends Serializable> {  
  
    /** 
     * 保存对象 
     *  
     * @param o 
     * @return 
     */  
    public Serializable save(T o);  
  
    /** 
     * 删除对象 
     *  
     * @param o 
     */  
    public void delete(T o);  
  
    /** 
     * 更新对象 
     *  
     * @param o 
     */  
    public void update(T o);  
  
    /** 
     * 保存或更新对象 
     *  
     * @param o 
     */  
    public void saveOrUpdate(T o);  
  
    /** 
     * 查询 
     *  
     * @param hql 
     * @return 
     */  
    public List<T> find(String hql);  
  
    /** 
     * 查询集合 
     *  
     * @param hql 
     * @param param 
     * @return 
     */  
    public List<T> find(String hql, Map<String, Object> params);  
  
    /** 
     * 查询集合(带分页) 
     *  
     * @param hql 
     * @param param 
     * @param page 
     *            查询第几页 
     * @param rows 
     *            每页显示几条记录 
     * @return 
     */  
    public List<T> find(String hql, Map<String, Object> params, Integer page, Integer rows);  
  
  
    /** 
     * 从数据库中获取对象
     *  
     * @param c 
     *            对象类型 
     * @param id 
     * @return Object 
     */  
    public T get(Serializable id);
    
    /**
     * 从代理中获取对象
     * @param id
     * @return
     */
    public T load(Serializable id);
  
  
    /** 
     * select count(*) from 类 
     *  
     * @param hql 
     * @return 
     */  
    public Long count(String hql);  
  
    /** 
     * select count(*) from 类 
     *  
     * @param hql 
     * @param param 
     * @return 
     */  
    public Long count(String hql, Map<String, Object> params);  
  
    /** 
     * 执行HQL语句 
     *  
     * @param hql 
     * @return 响应数目 
     */  
    public Integer executeHql(String hql);  
  
    /** 
     * 执行HQL语句 
     *  
     * @param hql 
     * @param param 
     * @return 响应数目 
     */  
    public Integer executeHql(String hql, Map<String, Object> params);  
  
} 
