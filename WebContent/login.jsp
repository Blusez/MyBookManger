<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
<body>
	<%
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/";
		session.setAttribute("basePath", basePath);
	%>
	<div align="center">
		<form action="LoginServlet" method="post">
			<table width="300" cellpadding="0" cellspacing="0" border="1"
				bordercolor="#C0c0c0">
				<caption>
					<strong>图书管理系统用户登录</strong>
				</caption>
				<tr>
					<td width="30%" height="35" align="right">用户名：</td>
					<td width="70%" height="35"><input type="text" name="name"
						value="${cookie.name.value }" /></td>
				</tr>
				<tr>
					<td width="30%" height="35" align="right">密码：</td>
					<td width="70%" height="35"><input type="password" name="pwd"
						value="${cookie.pwd.value }" /></td>
				</tr>
				<tr>
					<td width="30%" height="35" align="right"></td>
					<td width="70%" height="35"><input type="checkbox"
						name="autoLogin" />5天内自动登陆</td>
				</tr>
				<tr>
					<td height="35" align="center" colspan="2"><input
						type="submit" value="登陸"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>