package org.blog.service.impl;

import java.util.List;

import org.blog.dao.SortDao;
import org.blog.entity.Sort;
import org.blog.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**sort的业务逻辑实现类*/
@Service("sortService")
public class SortServiceImpl implements SortService {
	
	@Autowired
	private SortDao sortDao;

	@Override
	public int addSort(Sort sort) {
		// TODO Auto-generated method stub
		try {
			sortDao.save(sort);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Sort> findAll(Class<Sort> entity) {
		// TODO Auto-generated method stub
		return sortDao.findAll(entity);
	}

	@Override
	public int updateSort(Sort sort) {
		// TODO Auto-generated method stub
		try {
			sortDao.update(sort);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int deleteSort(int id){
		try{
			sortDao.delete(Sort.class,id);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

}
