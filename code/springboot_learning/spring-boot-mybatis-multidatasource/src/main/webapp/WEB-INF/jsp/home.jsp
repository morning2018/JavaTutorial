<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String ctx = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
</head>
<body>
	用户名：${username }<br/>
	密码：${password }<br/>
	<a href="<%=ctx%>/touser">新建用户</a>
	<a href="<%=ctx%>/tostaff">新建员工</a>
</body>
</html>