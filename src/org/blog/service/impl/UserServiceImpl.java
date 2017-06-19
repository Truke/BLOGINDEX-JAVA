package org.blog.service.impl;

import org.blog.dao.UserDao;
import org.blog.entity.User;
import org.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**user的业务逻辑实现类*/
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User validateUser(String user, String password){
		return userDao.validateUser(user, password);
	}
	
	@Override
	public int updatepwd(int id,String password,String newpassword){
		// TODO Auto-generated method stub
		try {
			User user = userDao.get(User.class, id);
			if(user.getPassword().equals(password)){
				user.setPassword(newpassword);
				userDao.update(user);
				return 1;
			}else{
				return -1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

}
