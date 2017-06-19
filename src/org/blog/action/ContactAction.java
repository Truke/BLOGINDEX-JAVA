package org.blog.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.blog.bean.PageBean;
import org.blog.entity.Contact;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@SuppressWarnings("serial")
@Controller("contactAction")
@Scope("session")
/**分类action*/
public class ContactAction extends BaseAction {
	private Contact contact;//contact
	private List<Contact> contacts;
	private PageBean pageBean;// 分页的Bean
	HttpSession session=ServletActionContext.getRequest().getSession();
	public List<Contact> getContacts() {
		return contacts;
	}

	private boolean success;//操作是否成功
	private Map<String, Object> data=new HashMap<String,Object>();
	
	public Map<String, Object> getData() {
		return data;
	}
	
	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	public String addContact(){
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		contact.setCreatetime(format.format(date));
		success=(contactService.addContact(contact)>0);
		data.clear();
		data.put("status",1);
		data.put("contact", contact);
		return SUCCESS;
	}
	
	public String findContacts(){
		if (pageBean == null) {
			pageBean = new PageBean();
		}
		// 如果页面大小为0，则设置默认大小
		if (pageBean.getSize() == 0) {
			pageBean.setSize(5);
		}
		// 总记录数
		pageBean.setCount(contactService.findAll(Contact.class).size());

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
		contacts=contactService.findPageContacts(pageBean);
		data.clear();
		data.put("status", 1);
		data.put("contacts", contacts);
		data.put("pageBean", pageBean);
		return SUCCESS;
	}
	
	public String updateIsread(){
		success = (contactService.updateIsread(contact.getId())>0);
		data.clear();
		data.put("status",1);
		data.put("msg", "已标记为已读");
		return SUCCESS;
	}
	
	public boolean isSuccess() {
		return success;
	}
}
