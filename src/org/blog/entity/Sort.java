package org.blog.entity;

/** 分类实体类 */
public class Sort {
	private int id;// id
	private String sort;// 分类
	
	public Sort(){}

	public Sort(int id, String sort) {
		this.id = id;
		this.sort = sort;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

}
