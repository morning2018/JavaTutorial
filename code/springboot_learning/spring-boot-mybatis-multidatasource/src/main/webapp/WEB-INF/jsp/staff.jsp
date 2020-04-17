<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String ctx = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head><title>新增员工</title></head>
 <body>
     <form action="<%=ctx%>/staff/addstaff" method="post" name="form1">
     	<table>
     		<tr>
     			<td>员工姓名</td>
     			<td><input type="text" name="staffName"></td>
     		</tr>
     		<tr>
     			<td>手机号</td>
     			<td><input type="text" name="phone"></td>
     		</tr>
     		<tr>
     			<td>邮箱</td>
     			<td><input type="text" name="email"></td>
     		</tr>
     		<tr>
     			<td colspan="2">
     				<input type="submit" value="新建">
     			</td>
     		</tr>
     	</table>
     </form>
 </body>
</html> 