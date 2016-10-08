<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>查询图书</h3>
		<form action="${basePath}BookServlet?reqtype=queryById" method="post">
			<table width="300" cellpadding="0" cellspacing="0" border="1"
				bordercolor="#c0c0c0">
				<tr>
					<td width="40%" align="right" height="35">图书编号</td>
					<td width="60%" align="left" height="35"><input type="text"
						name="bookid" value="${book.bookid}" readonly="readonly" /></td>
				</tr>
				<tr>
					<td align="center" height="35" colspan="2"><input
						type="submit" value="查询" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>