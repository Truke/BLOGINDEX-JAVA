package org.blog.entity;

/** 分类实体类 */
public class Contact {
	private int id;
	private String name;
	private String email;
	private String content;
	private int isread = 0;
	private String createtime;
	
	public Contact(){}
	
	public Contact(int id,String name,String email,String content,int isread){
		this.id = id;
		this.name = name;
		this.email = email;
		this.content = content;
		this.isread = isread;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIsread(){
		return isread;
	}
	public void setIsread(int isread){
		this.isread = isread;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
}
