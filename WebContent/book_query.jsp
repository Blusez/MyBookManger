<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		var url = "BookServlet";
		$("#querrybyid").click(function() {
			sendData = {
				reqtype : "queryById",
				bookid : $("input[name='bookid']").val()
			}
			$.post(url, sendData, function(data,status) {
				if(status=="success")
					showd(data)
				else
					$("#showdata").html("没有这本书")
					
			}, "json",function(error){
			})
			
		});
		function showd(data) {
			$("#showdata" ).empty()
			$tr = '<h1>图书</h1><table width="80%" cellpadding="0" cellspacing="0" border="1"bordercolor="#c0c0c0"><tr><td width="15%" height="35" align="center">'
					+ data.bookid
					+ '</td><td width="15%" height="35" align="center">'
					+ data.bookname
					+ '</td><td width="15%" height="35" align="center">'
					+ data.bookauthor
					+ '</td><td width="15%" height="35" align="center">'
					+ data.booktype
					+ '</td><td width="10%" height="35" align="center">'
					+ data.bookprice
					+ '</td><td width="15%" height="35" align="center">'
					+ data.bookdate
					+ '</td><td width="15%" height="35" align="center"><button>删除</button></td</tr></table>';
			$("#showdata").append($tr);
		}
	})
</script>
</head>
<body>
	<div align="center">
		<h3>查询图书</h3>
		<table width="500" cellpadding="0" cellspacing="0" border="1"
			bordercolor="#c0c0c0">
			<tr>
				<td width="40%" align="center" height="35"><input type="text"
					name="bookid" /></td>
				<td align="center" height="35">
					<button value="按ID查询" id="querrybyid">按ID查询</button>
				</td>
			</tr>

			<tr>
				<td width="40%" align="center" height="35"><input type="text"
					name="bookname" /></td>
				<td align="center" height="35"><input type="submit"
					value="按书名查询"></td>
			</tr>

			<tr>
				<td width="40%" align="center" height="35"><input type="text"
					name="bookauthor" value="${book.bookauthor}" /></td>
				<td align="center" height="35"><input type="submit"
					value="按作者查询" /></td>
			</tr>

		</table>
	</div>
	<div id="showdata" align="center"></div>
</body>
</html>