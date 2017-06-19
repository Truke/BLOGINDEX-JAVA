package org.blog.service.impl;

import java.util.List;

import org.blog.bean.BlogCondition;
import org.blog.bean.PageBean;
import org.blog.dao.BlogDao;
import org.blog.entity.Blog;
import org.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**blog业务逻辑的实现类*/
@Service("blogService")
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao blogDao;
	@Override
	public int addBlog(Blog blog) {
		// TODO Auto-generated method stub
		try{
			blogDao.save(blog);
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteBlog(int id) {
		// TODO Auto-generated method stub
		try {
			blogDao.delete(Blog.class,id);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Blog findBlog(int id) {
		// TODO Auto-generated method stub
		Blog blog = blogDao.get(Blog.class, id);
		int view = blog.getView()+1;
		blog.setView(view);
		blogDao.update(blog);
		return blog;
	}

	@Override
	public int updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		try {
			blogDao.update(blog);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public long findCount(BlogCondition condition) {
		// TODO Auto-generated method stub
		return blogDao.findCount(condition);
	}

	@Override
	public List<Blog> findPageBlogs(PageBean pageBean, BlogCondition condition) {
		// TODO Auto-generated method stub
		return blogDao.findBlogs(pageBean, condition);
	}

}
