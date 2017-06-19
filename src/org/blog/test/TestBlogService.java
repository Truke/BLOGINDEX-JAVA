package org.blog.test;

import java.util.ArrayList;
import java.util.List;

import org.blog.bean.BlogCondition;
import org.blog.bean.PageBean;
import org.blog.entity.Blog;
import org.blog.service.BlogService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBlogService {
	private static ApplicationContext context;
	
	private BlogService blogService;
	
	@BeforeClass
	public static void begin(){
		try {
			context=new ClassPathXmlApplicationContext("applicationContext.xml");
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public static void end(){
		context=null;
	}
	
	@Before
	public void before(){
		try {
			blogService=context.getBean(BlogService.class);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindBlog(){
		try {
			Blog blog=blogService.findBlog(1);
			System.out.println(blog.getTitle());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testFindPageBlogs(){
		
			PageBean pageBean=new PageBean();
			BlogCondition condition=new BlogCondition();
			List<Blog> list=new ArrayList<Blog>();
			list=blogService.findPageBlogs(pageBean, condition);
			for(Blog i:list){
				System.out.println(i.getTitle());
			}
	}
	@Test
	public void FindCount(){
		BlogCondition condition=new BlogCondition();
		Long l=blogService.findCount(condition);
		System.out.println(l);
	}
	
	@After
	public void after(){
		blogService=null;
	}
	
}
