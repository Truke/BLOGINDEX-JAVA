package org.blog.service;

import java.util.List;

import org.blog.entity.Sort;
/**sort业务逻辑接口*/
public interface SortService {
	/**添加sort */
	public int addSort(Sort sort);
	
	/**查询所有sort*/
	public List<Sort> findAll(Class<Sort> entity);
	
	/**更新sort*/
	public int updateSort(Sort sort);
	
	/**删除sort*/
	public int deleteSort(int id);
}
