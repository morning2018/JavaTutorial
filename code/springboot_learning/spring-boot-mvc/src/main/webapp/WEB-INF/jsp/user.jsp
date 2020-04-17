<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String ctx = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head><title>Hello world Example</title></head>
 <body>
     <form action="<%=ctx%>/user/adduser" method="post" name="form1">
     	<table>
     		<tr>
     			<td>用户名</td>
     			<td><input type="text" name="username"></td>
     		</tr>
     		<tr>
     			<td>密码</td>
     			<td><input type="password" name="password"></td>
     		</tr>
     		<tr>
     			<td>邮箱</td>
     			<td><input type="text" name="email"></td>
     		</tr>
     		<tr>
     			<td colspan="2">
     				<input type="submit" value="提交">
     			</td>
     		</tr>
     	</table>
     </form>
 </body>
</html> 