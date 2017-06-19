package org.blog.dao;

import java.util.List;

import org.blog.bean.BlogCondition;
import org.blog.bean.PageBean;
import org.blog.entity.Blog;
import org.blog.entity.Contact;
/**contactDao*/
public interface ContactDao extends BaseDao<Contact> {
	/**查询满足条件的记录*/
	public List<Contact> findContacts(PageBean pageBean);
}
