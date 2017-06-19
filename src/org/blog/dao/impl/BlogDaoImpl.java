package org.blog.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.blog.bean.BlogCondition;
import org.blog.bean.PageBean;
import org.blog.dao.BlogDao;
import org.blog.entity.Blog;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**blogDAO的实现类*/
@Repository("blogDao")
public class BlogDaoImpl extends BaseDaoImpl<Blog> implements BlogDao {

	/**通过查询条件创建供其他方法调用的DetachedCriteria对象*/
	private DetachedCriteria createDetachedCriteria(BlogCondition condition) {
		DetachedCriteria dc = DetachedCriteria.forClass(Blog.class);
		if (condition != null) {
			if (condition.getSort() != null && !"".equals(condition)) {
				System.out.println(condition.getSort());
				dc.add(Restrictions.ilike("sort", condition.getSort(),MatchMode.ANYWHERE));
			}
			if (condition.getTag() != null && !"".equals(condition)) {
				dc.add(Restrictions.ilike("tag", condition.getTag(),MatchMode.ANYWHERE));
			}
			if (condition.getStartTime() != null) {

			}
			if (condition.getFinishTime() != null) {

			}
		}
		return dc;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> findBlogs(PageBean pageBean, BlogCondition condition) {
		// TODO Auto-generated method stub
		int firstResult = (pageBean.getPage() - 1) * pageBean.getSize();
		int maxResults = pageBean.getSize();
		Criteria criteria = createDetachedCriteria(condition).getExecutableCriteria(super.getSession());
		criteria.setFirstResult(firstResult);
		criteria.setMaxResults(maxResults);

		criteria.addOrder(Order.desc("id"));
		return criteria.list();

	}

	@Override
	public long findCount(BlogCondition condition) {
		// TODO Auto-generated method stub
		Criteria criteria = createDetachedCriteria(condition).getExecutableCriteria(super.getSession());
		criteria.setProjection(Projections.count("id"));
		return (Long) criteria.uniqueResult();
	}
	

}
