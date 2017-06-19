package org.blog.service;

import java.util.List;

import org.blog.bean.BlogCondition;
import org.blog.bean.PageBean;
import org.blog.entity.Blog;

/**blog的业务逻辑接口*/
public interface BlogService {
	/**添加blog */
	public int addBlog(Blog blog);

	/**ͨ通过id删除删除blog*/
	public int deleteBlog(int id);

	/**通过id查询blog*/
	public Blog findBlog(int id);

	/**更新blog*/
	public int updateBlog(Blog blog);

	/** 通过查询条件得到记录数 */
	public long findCount(BlogCondition condition);

	/**查询一页的数据*/
	public List<Blog> findPageBlogs(PageBean pageBean, BlogCondition condition);
}
