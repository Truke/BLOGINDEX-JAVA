package org.blog.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ImgUploadAction extends ActionSupport {    
    private static final long serialVersionUID = 1L;  
    private String err = "";      
    private File fileData;           //上传文件    
    private String fileDataFileName; //文件名    
    HttpSession session=ServletActionContext.getRequest().getSession();
    private Map<String, Object> data = new HashMap<String, Object>();
    public String imgUpload() {    
        //获取response、request对象    
        ActionContext ac = ActionContext.getContext();    
        HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);    
        HttpServletRequest request = (HttpServletRequest) ac.get(ServletActionContext.HTTP_REQUEST);    
            
        response.setContentType("text/html;charset=gbk");          
    
        String saveRealFilePath = ServletActionContext.getServletContext().getRealPath("/pic");    
        File fileDir = new File(saveRealFilePath);    
        if (!fileDir.exists()) { //如果不存在 则创建     
            fileDir.mkdirs();    
        }    
        File savefile;    
        savefile = new File(saveRealFilePath + "/" + fileDataFileName);
        try {    
            FileUtils.copyFile(fileData, savefile);   
            String file_Name = request.getContextPath() + "/pic/" + fileDataFileName;
            data.clear();
            data.put("status",1);
            data.put("file_path",file_Name);
            return SUCCESS;
        } catch (IOException e) {
            data.clear();
            data.put("status", 0);
            data.put("msg", e.getMessage());
            e.printStackTrace();
            return ERROR;
        }  
    }    
    
    public String getErr() {    
        return err;    
    }    
    public void setErr(String err) {    
        this.err = err;    
    }    
      
    public Map<String, Object> getData() {
		return data;
	}  
    public File getFileData() {  
        return fileData;  
    }  
    public void setFileData(File fileData) {  
        this.fileData = fileData;  
    }  
      
    public String getFileDataFileName() {  
        return fileDataFileName;  
    }  
    public void setFileDataFileName(String fileDataFileName) {  
        this.fileDataFileName = fileDataFileName;  
    }    
} 