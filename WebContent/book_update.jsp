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
		<h3>更新图书</h3>
		<form action="${basePath}BookServlet?reqtype=update" method="post">
			<table width="300" cellpadding="0" cellspacing="0" border="1"
				bordercolor="#c0c0c0">
				<tr>
					<td width="40%" align="right" height="35">图书编号</td>
					<td width="60%" align="left" height="35"><input type="text"
						name="bookid" value="${book.bookid}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td width="40%" align="right" height="35">图书名称</td>
					<td width="60%" align="left" height="35"><input type="text"
						name="bookname"  value="${book.bookname}" /></td>
				</tr>
				<tr>
					<td width="40%" align="right" height="35">图书作者</td>
					<td width="60%" align="left" height="35"><input type="text"
						name="bookauthor" value="${book.bookauthor}"  /></td>
				</tr>
				<tr>
					<td width="40%" align="right" height="35">图书类型</td>
					<td width="60%" align="left" height="35"><input type="text"
						name="booktype" value="${book.booktype}"  /></td>
				</tr>
				<tr>
					<td width="40%" align="right" height="35">图书价格</td>
					<td width="60%" align="left" height="35"><input type="text"
						name="bookprice"  value="${book.bookprice}" /></td>
				</tr>
				<tr>
					<td width="40%" align="right" height="35">出版日期</td>
					<td width="60%" align="left" height="35"><input type="text"
						name="bookdate" value="${book.bookdate}"  /></td>
				</tr>
				<tr>
					<td align="center" height="35" colspan="2"><input
						type="submit" value="修改" /></td>

				</tr>

			</table>
		</form>



	</div>





</body>
</html>