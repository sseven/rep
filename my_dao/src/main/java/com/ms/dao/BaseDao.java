package com.ms.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@SuppressWarnings("all")
@Repository
public class BaseDao<T, ID extends Serializable> implements IBaseDao<T, ID> {

	//
	private Log logger = LogFactory.getLog(getClass());
	protected Class<T> entityClass;
	  
    protected Class getEntityClass() {
      if (this.entityClass == null) {
        this.entityClass = ((Class)((java.lang.reflect.ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]);

        this.logger.debug("T class = " + this.entityClass.getName());
      }
      return this.entityClass;
    }
  
    @Override
    public T load(Serializable id) {
    	return (T) this.getCurrentSession().load(getEntityClass(), id);
    }
    
    @Override
    public T get(Serializable id) {
    	return (T) this.getCurrentSession().get(getEntityClass(), id);
    }
    
    @Override
    public Serializable save(T o) {  
        return this.getCurrentSession().save(o);  
    }  
  
    @Override
    public void delete(T o) {  
        this.getCurrentSession().delete(o);  
    }
  
    @Override
    public void update(T o) {  
        this.getCurrentSession().update(o);  
    }  
  
    @Override
    public void saveOrUpdate(T o) {  
        this.getCurrentSession().saveOrUpdate(o);  
    }  
  
    @Override
    public List<T> find(String hql) {  
        return this.getCurrentSession().createQuery(hql).list();  
    }
    
    @Override
    public Long count(String hql) {  
        return (Long) this.getCurrentSession().createQuery(hql).uniqueResult();  
    }
  
    @Override
    public List<T> find(String hql, Map<String, Object> params) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (params != null && params.size() >= 1) {
        	for (Map.Entry<String, Object> e : params.entrySet()) {
        		q.setParameter(e.getKey(), e.getValue());
			}
        }  
        return q.list();  
    }
    
	@Override
	public Long count(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
        if (params != null && params.size() >= 1) {
        	for (Map.Entry<String, Object> e : params.entrySet()) {
        		q.setParameter(e.getKey(), e.getValue());
			}
        }  
        return (Long) q.uniqueResult();
	}
    
    @Override
    public List<T> find(String hql, Map<String, Object> params, Integer page, Integer rows) {   
        Query q = this.getCurrentSession().createQuery(hql);  
        if (params != null && params.size() >= 1) {  
        	for (Map.Entry<String, Object> e : params.entrySet()) {
        		q.setParameter(e.getKey(), e.getValue());
			}  
        }  
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();  
    }  
  
    @Override
    public Integer executeHql(String hql) {  
        return this.getCurrentSession().createQuery(hql).executeUpdate();  
    }  
  
    @Override
    public Integer executeHql(String hql, Map<String, Object> params) {  
        Query q = this.getCurrentSession().createQuery(hql);  
        if (params != null && params.size() > 0) {  
        	for (Map.Entry<String, Object> e : params.entrySet()) {
        		q.setParameter(e.getKey(), e.getValue());
			}  
        }  
        return q.executeUpdate();  
    }
    
    
    @Resource	
	private SessionFactory sessionFactory;  
	  
    public SessionFactory getSessionFactory() {  
        return sessionFactory;  
    } 
    
    public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    }  
  
    private Session getCurrentSession() {  
        return sessionFactory.getCurrentSession();  
    }


  
}  
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * HQL查询符合条件记录 hql: 查询HQL语句
	 *//*
	@SuppressWarnings("rawtypes")
	public List findByHQL(String hql) {
		return getResultList(hql, null, 0, 0);
	}

	*//**
	 * HQL查询符合条件记录 hql: 查询HQL语句 pageIndex：当前页码 pageSize：每页显示条数
	 *//*
	@SuppressWarnings("rawtypes")
	public List findByHQL(String hql, int pageIndex, int pageSize) {
		return getResultList(hql, null, pageIndex, pageSize);
	}

	*//**
	 * HQL查询符合条件记录 hql: 查询HQL语句 parameters: 查询条件
	 *//*
	@SuppressWarnings("rawtypes")
	public List findByHQL(String hql, Map<String, Object> parameters) {
		return getResultList(hql, parameters, 0, 0);
	}

	*//**
	 * HQL查询符合条件记录 hql: 查询HQL语句 parameters: 查询条件 pageIndex：当前页码 pageSize：每页显示条数
	 *//*
	@SuppressWarnings("rawtypes")
	public List findByHQL(String hql, Map<String, Object> parameters, int pageIndex, int pageSize) {
		return getResultList(hql, parameters, pageIndex, pageSize);
	}

	*//**
	 * 扩展（为了能使用命名参数查询与分页结合） mao.s
	 *//*
	public void findByHQL(String hql, String countHql, Map<String, Object> parameters, Datapager ps) {
		List<Object> list = getResultList(hql, parameters, ps.getTargetPage(), ps.getPageSize());
		int ct = countByHQL(countHql, parameters);
		ps.setTotalRows(ct);
		ps.setCurrentPage(ps.getTargetPage());
		ps.setData(list);
	}

	*//**
	 * 查询符合条件记录 query: 查询Query对象 parameters: 查询条件 pageIndex：当前页码 pageSize：每页显示条数
	 *//*
	private List getResultList(final String hql, final Map<String, Object> parameters, final int pageIndex, final int pageSize) {
		// 是否启用查询缓存
		Query query = getCurrentSession().createQuery(hql);
		if (parameters != null) {
			for (Map.Entry<String, Object> entry : parameters.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		if (pageIndex > 0) {
			query.setFirstResult((pageIndex - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		return query.list();
	}
	*//**
	 * 查询符合条件记录 query: 查询Query对象 parameters: 查询条件 pageIndex：当前页码 pageSize：每页显示条数
	 *//*
	public List findResultList(final String hql, final Map<String, Object> parameters, final int pageIndex, final int pageSize) {
		Query query = getCurrentSession().createQuery(hql);
		if (parameters != null) {
			for (Map.Entry<String, Object> entry : parameters.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		if (pageIndex > 0) {
			query.setFirstResult((pageIndex - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		return query.list();
	}

	public int countByHQL(String hql) {
		return count(hql, null);
	}

	*//**
	 * HQL查询符合条件记录总数 hql: 查询HQL语句 parameters: 查询条件
	 *//*
	public int countByHQL(String hql, Map<String, Object> parameters) {
		return count(hql, parameters);
	}

	*//**
	 * 查询符合条件记录总数 query: 查询Query对象 parameters: 查询条件
	 *//*
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private int count(final String hql, final Map<String, Object> parameters) {
		Query query = getCurrentSession().createQuery(hql);
		if (parameters != null) {
			for (Map.Entry<String, Object> entry : parameters.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		Object result = query.uniqueResult();
		return result == null ? 0 : result instanceof Integer ? ((Integer) result).intValue() : ((Long) result).intValue();
	}


	public List findBySql(String sql, final Map<String, Object> parameters, int pageIndex, int pageSize) {
		Session session = getCurrentSession();
		Query query = session.createSQLQuery(sql);
		query.setFirstResult(pageIndex);
		query.setMaxResults(pageSize);
		if (parameters != null) {
			for (Map.Entry<String, Object> entry : parameters.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return query.list();
	}

	public List findBySql(String sql, final Map<String, Object> parameters) {
		Session session = getCurrentSession();
		Query query = session.createSQLQuery(sql);
		if (parameters != null) {
			for (Map.Entry<String, Object> entry : parameters.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return query.list();
	}

	*//**
	 * 根据HQL更新操作 hql: HQL语句 parameters: 查询条件
	 *//*
	public void executeByHQL(String hql, Map<String, Object> parameters) {
		execute(hql, parameters);
	}

	*//**
	 * 更新操作 query: 查询Query对象 parameters: 查询条件
	 *//*
	private void execute(final String hql, final Map<String, Object> parameters) {
		Query query = getCurrentSession().createQuery(hql);
		if (parameters != null) {
			for (Map.Entry<String, Object> entry : parameters.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		query.executeUpdate();
	}*/

	/**
	 * orderBy字符串中格式为“字段 排序方式”
	 */
	/*@Override
	public List<T> find(Class<T> c, String where, String orderBy, String... params) {
		if (null == params || params.length == 0) {
			return null;
		}
		Session currentSession = this.getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		for (String param : params) {
			sql.append(param);
			sql.append(",");
		}
		if (sql.toString().endsWith(",")) {
			sql.deleteCharAt(sql.toString().length() - 1);
		}
		sql.append(" from " + c.getAnnotation(Table.class).name());
		sql.append(" where " + where);
		if (null != orderBy && !"".equals(orderBy.trim())) {
			sql.append(" ORDER BY " + orderBy);
		}
		List<T> list = currentSession.createSQLQuery(sql.toString()).list();
		List<T> tlist = new ArrayList<T>();
		for (T t : list) {
			Object[] objs = (Object[]) t;
			try {
				T instance = c.newInstance();
				for (int i = 0; i < params.length; i++) {
					String param = params[i].substring(0, 1).toUpperCase()
							+ params[i].substring(1, params[i].length());
					Object obj = objs[i];

					Method[] methods = instance.getClass().getMethods();
					for (Method method : methods) {
						method.setAccessible(true);
						if (method.getName().equals("set" + param)) {
							Class[] parameterTypes = method.getParameterTypes();
							if (parameterTypes.length != 1) {
								return null;
							}
							String paramTypeName = parameterTypes[0]
									.getSimpleName();

							if ("String".equals(paramTypeName)) {
								method.invoke(instance, obj == null ? null
										: obj.toString());
							} else if ("int".equals(paramTypeName)) {
								method.invoke(instance,
										Integer.valueOf(obj.toString()));
							} else if ("Date".equals(paramTypeName)) {
								method.invoke(instance, obj == null ? null
										: (Date) obj);
							} else if ("double".equals(paramTypeName)) {
								method.invoke(instance,
										Double.valueOf(obj.toString()));
							} else if ("Integer".equals(paramTypeName)) {
								method.invoke(instance, obj == null ? null
										: Integer.valueOf(obj.toString()));
							}
						}
					}
				}
				tlist.add(instance);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		return tlist;
	}*/

