package org.blog.entity;
/**用户实体类*/
public class User {
	private int id;// id
	private String user; //用户名
	private String password;//密码

	public User(){}

	public User(int id, String user) {
		this.id = id;
		this.user = user;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
