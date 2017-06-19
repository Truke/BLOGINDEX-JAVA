package org.blog.dao;

import org.blog.entity.User;
/**user Dao*/
public interface UserDao extends BaseDao<User> {
	public User validateUser(String user, String password);
	
	
}
