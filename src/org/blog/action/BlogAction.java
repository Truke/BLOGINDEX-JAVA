package org.blog.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.blog.bean.BlogCondition;
import org.blog.bean.PageBean;
import org.blog.entity.Blog;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@SuppressWarnings("serial")
@Controller("blogAction")
@Scope("prototype")
public class BlogAction extends BaseAction {
	private Blog blog;// blog
	private List<Blog> blogs;// blog列表
	private PageBean pageBean;// 分页的Bean
	private BlogCondition blogCondition;// 封装查询条件的Bean，用于封装blogs和pageBean，返回给客户端

	private Map<String, Object> data = new HashMap<String, Object>();
	HttpServletResponse response = null;
	HttpServletRequest request = null;
	private boolean success;// 操作是否成功
	
	HttpSession session=ServletActionContext.getRequest().getSession();

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public BlogCondition getBlogCondition() {
		return blogCondition;
	}

	public void setBlogCondition(BlogCondition blogCondition) {
		this.blogCondition = blogCondition;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public boolean isSuccess() {
		return success;
	}

	/** 查询一页的数据 */
	public String list() {
		if (pageBean == null) {
			pageBean = new PageBean();
		}
		// 如果页面大小为0，则设置默认大小
		if (pageBean.getSize() == 0) {
			pageBean.setSize(5);
		}
		// 总记录数
		pageBean.setCount(blogService.findCount(blogCondition));
		

		// 页数
		long total = ((pageBean.getCount() % pageBean.getSize() == 0) ? pageBean
				.getCount() / pageBean.getSize()
				: pageBean.getCount() / pageBean.getSize() + 1);
		pageBean.setTotal(total);
		// 设置当前页面
		if (pageBean.getPage() <= 1) {
			pageBean.setPage(1);
		} else if (pageBean.getPage() >= total) {
			pageBean.setPage((int) total);
		}
		//设置当前页面的previous
		if(pageBean.getPage()>1){
			pageBean.setPrevious(pageBean.getPage()-1);
		}else{
			pageBean.setPrevious(0);
		}
		//设置当前页面的next
		if(pageBean.getPage()<total){
			pageBean.setNext(pageBean.getPage()+1);
		}else{
			pageBean.setNext(0);
		}
		// 查询当前页的数据
		blogs = blogService.findPageBlogs(pageBean, blogCondition);
		data.clear();
		data.put("status", 1);
		data.put("blogs", blogs);
		data.put("pageBean", pageBean);
		return SUCCESS;
	}

	/** 添加blog */
	public String addBlog() {
		if(session.getAttribute("user") == null){
			data.clear();
			data.put("status", 0);
			data.put("msg", "用户已失效，请重新登陆");
			return ERROR;
		}else{
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			blog.setCreateTime(format.format(date));
			blogService.addBlog(blog);
			data.clear();
			data.put("status", 1);
			data.put("blog", blog);
			return SUCCESS;
		}
	}

	/** 更新blog */
	public String updateBlog() {
		if(session.getAttribute("user") == null){
			data.clear();
			data.put("status", 0);
			data.put("msg", "用户已失效，请重新登陆");
			return ERROR;
		}else{
			success = (blogService.updateBlog(blog) > 0);
			data.clear();
			data.put("status", 1);
			data.put("msg", "已成功修改");
			return SUCCESS;
		}
	}

	/** 删除blog */
	public String deleteBlog() {
		if(session.getAttribute("user") == null){
			data.clear();
			data.put("status", 0);
			data.put("msg", "用户已失效，请重新登陆");
			return ERROR;
		}else{
			success = (blogService.deleteBlog(blog.getId()) > 0);
			data.clear();
			data.put("status", 1);
			data.put("msg", "已成功删除");
			return SUCCESS;
		}
	}

	/** 查询blog */
	public String findBlog() {
		blog = blogService.findBlog(blog.getId());
		data.put("blog", blog);
		return SUCCESS;
	}

}
