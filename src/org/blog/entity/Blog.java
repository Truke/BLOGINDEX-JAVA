package org.blog.entity;

/**blog实体类*/
public class Blog {
	private int id; // 主键
	private String title; // 标题
	private String subtitle;//副标题
	private String blog; // 内容
	private String tag; // 标签
	private String sort; // 分类
	private String createTime; // 发表时间
	private int view = 0;

	// 无参构造方法
	public Blog() {
	}

	// 全参构造方法
	public Blog(int id, String title,String subtitle, String blog, String tag, String sort,
			String createTime,int view) {
		this.id = id;
		this.title = title;
		this.subtitle = subtitle;
		this.blog = blog;
		this.tag = tag;
		this.sort = sort;
		this.createTime = createTime;
		this.view = view;
	}

	// getter和setter方法
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSubtitle(){
		return subtitle;
	}
	
	public void setSubtitle(String subtitle){
		this.subtitle = subtitle;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public void setView(int view){
		this.view = view;
	}
	public int getView(){
		return view;
	}
}