<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>图书信息列表</h3>
		<table width="80%" cellpadding="0" cellspacing="0" border="1"
			bordercolor="#C0C0C0">
			<tr>
				<td width="15%" height="35" align="center">图书编号</td>
				<td width="15%" height="35" align="center">图书名称</td>
				<td width="15%" height="35" align="center">图书作者</td>
				<td width="15%" height="35" align="center">图书类型</td>
				<td width="10%" height="35" align="center">图书价格</td>
				<td width="15%" height="35" align="center">出版日期</td>
				<td width="15%" height="35" align="center">操作</td>
			</tr>
			<c:forEach var="book" items="${book_list}">
				<tr>
					<td width="15%" height="35" align="center">${book.bookid}</td>
					<td width="15%" height="35" align="center">${book.bookname}</td>
					<td width="15%" height="35" align="center">${book.bookauthor}</td>
					<td width="15%" height="35" align="center">${book.booktype}</td>
					<td width="10%" height="35" align="center">${book.bookprice}</td>
					<td width="15%" height="35" align="center">${book.bookdate}</td>
					<td width="15%" height="35" align="center"><a
						href="${basePath}BookServlet?reqtype=updateById&bookid=${book.bookid}">修改</a>&nbsp;&nbsp;<a
						href="${basePath}BookServlet?reqtype=delete&bookid=${book.bookid}">删除</a></td>
				</tr>

			</c:forEach>



		</table>



	</div>






</body>
</html>