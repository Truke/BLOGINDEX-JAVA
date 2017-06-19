package org.blog.action;

import org.blog.service.BlogService;
import org.blog.service.SortService;
import org.blog.service.UserService;
import org.blog.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**建立一个通用的BaseAction，把项目中所有的业务类在这里注入，其他Action继承于它，可以省去注入的麻烦*/

@SuppressWarnings("serial")
@Controller("baseAction")
public class BaseAction extends ActionSupport {
	
	@Autowired
	protected BlogService blogService;
	
	@Autowired
	protected SortService sortService;
	
	@Autowired
	protected UserService userService;
	
	@Autowired
	protected ContactService contactService;
}
