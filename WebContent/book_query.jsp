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
		<h3>查询图书</h3>
		<form action="${basePath}BookServlet?reqtype=queryById" method="post">
			<table width="500" cellpadding="0" cellspacing="0" border="1"
				bordercolor="#c0c0c0">
				<tr>
					<td width="40%" align="center" height="35"><input type="text"
						name="bookid" value="${book.bookid}" /></td>
					<td align="center" height="35"><input type="submit"
						value="按ID查询" /></td>
				</tr>
			</table>
		</form>

		<form action="${basePath}BookServlet?reqtype=queryByName"
			method="post">
			<table width="500" cellpadding="0" cellspacing="0" border="1"
				bordercolor="#c0c0c0">
				<tr>
					<td width="40%" align="center" height="35"><input type="text"
						name="bookname" value="${book.bookname}" /></td>
					<td align="center" height="35"><input type="submit"
						value="按书名查询" /></td>
				</tr>
			</table>
		</form>

		<form action="${basePath}BookServlet?reqtype=queryByAuthor"
			method="post">
			<table width="500" cellpadding="0" cellspacing="0" border="1"
				bordercolor="#c0c0c0">
				<tr>
					<td width="40%" align="center" height="35"><input type="text"
						name="bookauthor" value="${book.bookauthor}" /></td>
					<td align="center" height="35"><input type="submit"
						value="按作者查询" /></td>
				</tr>
			</table>
		</form>
	</div>
	<c:if test="${ not empty book_list}">
		<jsp:include page="book_list.jsp"></jsp:include>
	</c:if>
	<c:if test="${(empty book_list)&&(not empty book)}">
		<c:out value="没有这本书"></c:out>
	</c:if>
</body>
</html>