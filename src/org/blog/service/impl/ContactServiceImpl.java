package org.blog.service.impl;

import java.util.List;

import org.blog.bean.BlogCondition;
import org.blog.bean.PageBean;
import org.blog.dao.ContactDao;
import org.blog.entity.Blog;
import org.blog.entity.Contact;
import org.blog.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**contact的业务逻辑实现类*/
@Service("contactService")
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDao contactDao;

	@Override
	public int addContact(Contact contact) {
		// TODO Auto-generated method stub
		try {
			contactDao.save(contact);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Contact> findAll(Class<Contact> entity) {
		// TODO Auto-generated method stub
		return contactDao.findAll(entity);
	}

	@Override
	public int updateIsread(int id){
		try{
			Contact contact = contactDao.get(Contact.class,id);
			contact.setIsread(1);
			contactDao.update(contact);
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public List<Contact> findPageContacts(PageBean pageBean) {
		// TODO Auto-generated method stub
		return contactDao.findContacts(pageBean);
	}

}
