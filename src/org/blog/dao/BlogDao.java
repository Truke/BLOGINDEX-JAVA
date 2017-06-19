package org.blog.dao;

import java.io.Serializable;
import java.util.List;

import org.blog.bean.BlogCondition;
import org.blog.bean.PageBean;
import org.blog.entity.Blog;

/**blogDAO*/
public interface BlogDao extends BaseDao<Blog> {
	/**查询满足条件的记录*/
	public List<Blog> findBlogs(PageBean pageBean, BlogCondition condition);

	/**查询满足条件的数量*/
	public long findCount(BlogCondition condition);
	
	
}
