<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <script src="http://apps.bdimg.com/libs/jquery/1.9.1/jquery.min.js"></script>
 <script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$("#submit").click(function(){
			var sort=$("#sort").val();
			$.post("addSort?sort.sort="+sort,function(){
				alert("ok"+sort);
			});
		});
	}); 
	
	</script> 
	--%>
<title>添加分类</title>
</head>
<body>
	<s:debug></s:debug>
	<s:if test="#session.admin==null">
		<script type="text/javascript">
			window.location.href = "/MyBlog/admin/login.jsp";
		</script>
	</s:if>
	<s:form method="POST" action="addSort">
		<s:textfield name="sort.sort" />
		<s:submit value="添加分类" />
	</s:form>
	<%-- <s:textfield name="sort.sort" id="sort"/>
	<s:submit value="添加分类" id="submit"/> --%>
</body>

</html>