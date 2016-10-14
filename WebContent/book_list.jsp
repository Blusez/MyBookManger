<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<script src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
	$(function(){
			var size = $("#size").val();
			$("#selectpage option[value='"+size+"']").attr("selected", true);
		$("#selectpage").change(function(){
			window.location.href='BookServlet?reqtype=page&pagesize='+$("#selectpage").val();
		});
	});
		function selectp(){
			var size = ${"size"};
			/* $("#selectpage").val(size); */
			/* $.get({
				url:"BookServlet?reqtype=page",
				data:{pagesize:$("#selectpage").val()},
				success:function(data){
					window.location.href='BookServlet?reqtype=pag';
				}
			}); */
		}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>图书信息列表</h3>
		<table width="80%" id="showbook" cellpadding="0" cellspacing="0" border="1"
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
			<tr>
				<td height="35" align="center" colspan="7">
					<c:choose>
						<c:when test="${pageUtil.pageCount >= 5 and pageUtil.currentPage < pageUtil.pageCount-5 }">
							<c:forEach
								begin="${pageUtil.currentPage>3 ? pageUtil.currentPage-2:pageUtil.currentPage }"
								end="${pageUtil.currentPage>3 ? pageUtil.currentPage+2 : pageUtil.currentPage+5 }" step="1" var="page">
								<a href="${basePath}BookServlet?reqtype=page&currentpage=${page}&pagesize=${pageUtil.pageSize}"><c:out
									value="${page }"></c:out></a>&nbsp;
							</c:forEach>
						</c:when>
						<c:when test="${pageUtil.currentPage >= pageUtil.pageCount-5 }">
							<c:forEach
								begin="${pageUtil.pageCount-5 }"
								end="${pageUtil.pageCount}" step="1" var="page">
								<a href="${basePath}BookServlet?reqtype=page&currentpage=${page}&pagesize=${pageUtil.pageSize}"><c:out
									value="${page }"></c:out></a>&nbsp;
							</c:forEach>
						</c:when>
						<c:when test="${pageUtil.pageCount < 5}">
							<c:forEach
								begin="${pageUtil.currentPage }"
								end="${pageUtil.pageCount }" step="1" var="page">
							<a href="${basePath}BookServlet?reqtype=page&currentpage=${page}&pagesize=${pageUtil.pageSize}"><c:out
								value="${page }"></c:out></a>&nbsp;
						</c:forEach>
						</c:when>
					</c:choose>
					 第${pageUtil.currentPage }页,共${pageUtil.pageCount}页&nbsp; 
					<a href="${basePath}BookServlet?reqtype=page&currentpage=1&pagesize=${pageUtil.pageSize}">首页</a>	
					<a href="${basePath}BookServlet?reqtype=page&currentpage=${pageUtil.pageCount}&pagesize=${pageUtil.pageSize}">尾页</a>	
					<a href="${basePath}BookServlet?reqtype=page&currentpage=${pageUtil.currentPage-1}&pagesize=${pageUtil.pageSize}">上一页</a>	
					<a href="${basePath}BookServlet?reqtype=page&currentpage=${pageUtil.currentPage+1}&pagesize=${pageUtil.pageSize}">下一页</a>	
					<input type="hidden" value="${pageUtil.pageSize}" id="size">
					<select id = "selectpage" >
						<option value="2" >2</option>
						<option value="5">5</option>
						<option value="10">10</option>
						<option value="50">50</option>
				    </select>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>