package org.blog.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.blog.entity.User;
import org.blog.util.VerificationCodeUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@SuppressWarnings("serial")
@Controller("LoginAction")
@Scope("session")
/**登录action*/
public class UserAction extends BaseAction{
	private User user;//user
	private boolean validated = false;
	HttpServletResponse response = null;
	HttpSession session=ServletActionContext.getRequest().getSession();
	private Map<String, Object> data = new HashMap<String, Object>();
	private ByteArrayInputStream inputStream;  
	public User getUser() {
		return user;
	}
	public void setUser(User user){
		this.user = user;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public String login() throws Exception {
		// TODO Auto-generated method stub
		String code = ServletActionContext.getRequest().getParameter("code");
		if(session.getAttribute("random").equals(code)){
			User u = userService.validateUser(user.getUser(),user.getPassword());
			if(u!=null){
				validated = true;
			}
			if(validated){
				session.setAttribute("user", user.getUser());
				data.clear();
				data.put("userid", u.getId());
				data.put("username", user.getUser());
				data.put("status", 1);
				data.put("msg", "登陆成功");
				return SUCCESS;
			}else{
				data.clear();
				data.put("status", 0);
				data.put("msg", "用户名或密码错误");
				return ERROR;
			}
		}
		data.clear();
		data.put("status", 0);
		data.put("msg", "验证码错误");
		return ERROR;
	}
	
	public String loginout(){
		if(session.getAttribute("user")!=null){
			session.removeAttribute("user");
			session.invalidate();
			data.clear();
			data.put("status", 1);
			data.put("msg", "已退出");
			return SUCCESS;
		}else{
			data.clear();
			data.put("status", 0);
			data.put("msg", "用户已失效，请重新登录");
			return ERROR;
		}
		
	}
	
	public String changepwd(){
		String newpassword = ServletActionContext.getRequest().getParameter("newpassword");
		int status = userService.updatepwd(user.getId(),user.getPassword(),newpassword);
		if(status==0){
			data.clear();
			data.put("status", 0);
			data.put("msg", "修改密码异常，请重新输入");
			return ERROR;
		}else if(status==-1){
			data.clear();
			data.put("status", 0);
			data.put("msg", "原密码错误");
			return ERROR;
		}
		else if(status==1){
			data.clear();
			data.put("status", 1);
			data.put("msg", "已修改");
		}
		return SUCCESS;
	}
	public String getRandomPictrue() {    
	    VerificationCodeUtil vcu = VerificationCodeUtil.Instance();    
	    session.setAttribute("random", vcu.getVerificationCodeValue());
	    this.setInputStream(vcu.getImage());
	    return SUCCESS;    
	    
	}    
}
