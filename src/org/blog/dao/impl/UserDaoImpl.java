package org.blog.dao.impl;

import java.util.List;

import org.blog.dao.UserDao;
import org.blog.entity.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public User validateUser(String user, String password){
		String sql = "from User u where u.user=? and u.password=?";
		Query query = getSession().createQuery(sql);
		query.setParameter(0, user);
		query.setParameter(1, password);
		List<User> users=query.list();
		if(users.size()!=0){
			return (User) users.get(0);
		}
		return null;
	}
	
	
}
