<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<div>

		<p>
			欢迎<font color="red">${sessionScope.user.username}</font>登录成功，目前在线人数<font color="blue">${user_list.size() }</font>
		</p>
	</div>


</body>
</html>