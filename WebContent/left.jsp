<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
a:LINK {
	color: black;
	text-decoration: none;
}

a:VISITED {
	color: black;
	text-decoration: none;
}

a:HOVER {
	color: blue;
	text-decoration: underline;
}

a:ACTIVE {
	color: blue;
	text-decoration: underline;
}

ul {
	margin: 100px auto;
}

ul li {
	margin-top: 5px;
}
</style>
</head>
<body>

	<ul>
		<li><a href="${basePath}book_list.jsp" target="main">图书信息列表</a></li>
		<li><a href="${basePath}book_add.jsp" target="main">新增图书</a></li>
		<li><a href="${basePath}book_query.jsp" target="main">查询图书信息</a></li>
		<li><a href="${basePath}LoginServlet?reqtype=logout"
			target="_top">退出登录</a></li>
	</ul>




	</div>

</body>
</html>