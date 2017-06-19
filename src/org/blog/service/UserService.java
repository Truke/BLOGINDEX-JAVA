package org.blog.service;

import org.blog.entity.User;
/**user业务逻辑接口*/
public interface UserService {
	public User validateUser(String user, String password);
	
	public int updatepwd(int id,String password,String newpassword);
	
}
