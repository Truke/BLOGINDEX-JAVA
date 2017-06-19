<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet
	href="/MyBlog/ueditor/themes/default/css/ueditor.css">
<script type="text/javascript" charset="utf-8"
	src="/MyBlog/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="/MyBlog/ueditor/ueditor.all.js"></script>
<script src="http://apps.bdimg.com/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="/MyBlog/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$.post("/MyBlog/findSorts.action",function(data){
			var sorts=data.sorts;
			html="";
			for(var i=0;i<sorts.length;i++){
				html = html + "<option>" + sorts[i]['sort'] + "</option>";
			}
			$("#sort").html(html);
		});
	});

</script>
<title>发表日志</title>
</head>
<body>
	<s:if test="#session.admin==null">
		<script type="text/javascript">
			window.location.href = "/MyBlog/admin/login.jsp";
		</script>
	</s:if>
	<s:form method="POST" action="addBlog">
	标题<s:textfield name="blog.title" id="title" />
 	分类<select name="blog.sort" id="sort"></select>
 	标签：<s:textfield name="blog.tag" id="tag"></s:textfield>
		<textarea id="editor" name="blog.blog"></textarea>
		<script id="editor" type="text/plain"></script>
		<script type="text/javascript">
			var ue = UE.getEditor('editor');
		</script>
		<s:hidden name="blog.createTime"></s:hidden>
		<s:submit value="发表博客" id="submit" />
	</s:form>
</body>
</html>