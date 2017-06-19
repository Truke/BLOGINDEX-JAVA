package org.blog.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.blog.entity.Sort;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@SuppressWarnings("serial")
@Controller("sortAction")
@Scope("session")
/**分类action*/
public class SortAction extends BaseAction {
	private Sort sort;//sort
	private List<Sort> sorts;
	HttpSession session=ServletActionContext.getRequest().getSession();
	public List<Sort> getSorts() {
		return sorts;
	}

	private boolean success;//操作是否成功
	private Map<String, Object> data=new HashMap<String,Object>();
	
	public Map<String, Object> getData() {
		return data;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}
	
	public String addSort(){
		if(session.getAttribute("user") == null){
			data.clear();
			data.put("status", 0);
			data.put("msg", "用户已失效，请重新登陆");
			return ERROR;
		}else{
			success=(sortService.addSort(sort)>0);
			System.out.println(success);
			data.clear();
			data.put("status",1);
			data.put("sort", sort);
			return SUCCESS;
		}
	}
	public String updateSort(){
		if(session.getAttribute("user") == null){
			data.clear();
			data.put("status", 0);
			data.put("msg", "用户已失效，请重新登陆");
			return ERROR;
		}else{
			success=(sortService.updateSort(sort)>0);
			data.put("status", 1);
			data.put("msg", "已成功修改");
			return SUCCESS;
		}
	}
	
	public String findSorts(){
		sorts=sortService.findAll(Sort.class);
		data.clear();
		data.put("status", 1);
		data.put("sorts", sorts);
		return SUCCESS;
	}
	
	/** 删除sort */
	public String deleteSort() {
		if(session.getAttribute("user") == null){
			data.clear();
			data.put("status", 0);
			data.put("msg", "用户已失效，请重新登陆");
			return ERROR;
		}else{
			success = (sortService.deleteSort(sort.getId()) > 0);
			data.clear();
			data.put("status", 1);
			data.put("msg", "已成功删除");
			return SUCCESS;
		}
	}

	public boolean isSuccess() {
		return success;
	}
}
