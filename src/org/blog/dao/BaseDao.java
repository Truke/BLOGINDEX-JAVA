package org.blog.dao;

import java.io.Serializable;
import java.util.List;
/**所有DAO接口的父接口*/
public interface BaseDao<T> {

	/**根据主键删除对象*/
	public void delete(Class<T> entity, Serializable id);

	/**删除实体对象*/
	public void delete(T entity);

	/**查找多有对象，封装成List对象*/
	public List<T> findAll(Class<T> entity);

	/**根据属性查找对象*/ 
	public List<T> findByProperty(Class<T> clazz, String property, Object value);

	/**查询对象记录条数*/
	public long findCount(Class<T> entity);

	/**查一页的数据*/
	public List<T> find(Class<T> entity, final int firstResult,
			final int maxResults);
	/**根据主键找对象*/
	public T get(Class<T> entity, Serializable id);

	/**添加一条记录*/
	public Serializable save(T entity);

	/**添加或更新记录*/
	public void saveOrUpdate(T entity);

	/**更新记录*/
	public void update(T entity);
	

}
