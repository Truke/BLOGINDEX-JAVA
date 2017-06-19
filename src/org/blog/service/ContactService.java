package org.blog.service;

import java.util.List;

import org.blog.bean.BlogCondition;
import org.blog.bean.PageBean;
import org.blog.entity.Blog;
import org.blog.entity.Contact;
/**contact业务逻辑接口*/
public interface ContactService {
	/**添加contact */
	public int addContact(Contact contact);
	
	/**查询所有contact*/
	public List<Contact> findAll(Class<Contact> entity);
	
	public int updateIsread(int id);
	
	/**查询一页的数据*/
	public List<Contact> findPageContacts(PageBean pageBean);
}
