package org.blog.dao.impl;

import java.util.List;

import org.blog.bean.BlogCondition;
import org.blog.bean.PageBean;
import org.blog.dao.ContactDao;
import org.blog.entity.Blog;
import org.blog.entity.Contact;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
@Repository("contactDao")
public class ContactDaoImpl extends BaseDaoImpl<Contact> implements ContactDao {
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> findContacts(PageBean pageBean) {
		// TODO Auto-generated method stub
		int firstResult = (pageBean.getPage() - 1) * pageBean.getSize();
		int maxResults = pageBean.getSize();
		Criteria criteria = DetachedCriteria.forClass(Contact.class).getExecutableCriteria(super.getSession());
		criteria.setFirstResult(firstResult);
		criteria.setMaxResults(maxResults);

		criteria.addOrder(Order.desc("id"));
		return criteria.list();

	}
}
