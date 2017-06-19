package org.blog.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.blog.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**通用的BaseDao的实现类，作为所有Dao实现类的父类*/
public class BaseDaoImpl<T> implements BaseDao<T> {

	/**通过@Resource注入回话工厂*/
	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

//	/**得到回话*/
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void delete(Class<T> entity, Serializable id) {
		// TODO Auto-generated method stub
		getSession().delete(getSession().get(entity, id));
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		getSession().delete(entity);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> entity) {
		// TODO Auto-generated method stub
		return getSession().createCriteria(entity).addOrder(Order.desc("id")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByProperty(Class<T> clazz, String property, Object value) {
		// TODO Auto-generated method stub
		return getSession().createCriteria(clazz)
				.add(Restrictions.eq(property, value)).list();
	}

	@Override
	public long findCount(Class<T> entity) {
		// TODO Auto-generated method stub
		return (Long) getSession().createQuery(
				"select count(*) from " + entity.getName()).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(Class<T> entity, int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return getSession().createCriteria(entity).setFirstResult(firstResult)
				.setMaxResults(maxResults).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Class<T> entity, Serializable id) {
		// TODO Auto-generated method stub
		return (T) getSession().get(entity, id);
	}

	@Override
	public Serializable save(T entity) {
		// TODO Auto-generated method stub
		return getSession().save(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(entity);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		getSession().update(entity);
	}
}
