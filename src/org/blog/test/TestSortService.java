package org.blog.test;

import java.util.ArrayList;
import java.util.List;
import org.blog.entity.Sort;
import org.blog.service.SortService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSortService {
private static ApplicationContext context;
	
	private SortService sortService;
	
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
			sortService=context.getBean(SortService.class);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void TestInsert(){
		Sort sort=new Sort();
		sort.setSort("nihao");
		sortService.addSort(sort);
		sort.setSort("m");
	}
	
	@Test
	public void TestUpdate(){
		Sort sort=new Sort();
		sort.setSort("mi");
		int i=sortService.updateSort(sort);
		System.out.print(i);
	}
	
	@Test
	public void testFindAll(){
		try {
			List<Sort> list=new ArrayList<Sort>();
			list=sortService.findAll(Sort.class);
			for(Sort i:list){
				System.out.println(i.getSort());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void after(){
		sortService=null;
	}
}
