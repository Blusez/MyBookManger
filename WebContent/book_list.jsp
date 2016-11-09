<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
	$(function() {

		var url = "BookServlet";
		//
		(function() {
			var sendData = {
				"reqtype" : "page",
				"currentpage" : "1"
			};

			$.post(url, sendData, function(data) {
				showdata(data);
			}, "json");
		})();

		//设置页面大小
		$("#selectpage").change(function() {
			var sendData = {
				reqtype : "page",
				pagesize : $("#selectpage").val(),
			};
			$.post(url, sendData, function(data) {
				showdata(data);
			}, "json");
			//window.location.href='BookServlet?reqtype=page&pagesize='+$("#selectpage").val();
		});

		//设置上下页
		function selectPage(currentpage, pagesize) {
			var sendData = {
				reqtype : "page",
				currentpage : currentpage,
				pagesize : pagesize
			};
			$.post(url, sendData, function(data) {

			})
		}

		function showdata(data) {
			$("#selectpage option[value='" + data.pageUtil.pageSize + "']")
					.attr("selected", true);
			$("#table_book_list tr:gt(0)").remove();
			$
					.each(
							data.book_list,
							function(i, book) {
								var $tr = $('<tr><td width="15%" height="35" align="center">'
										+ book.bookid
										+ '</td><td width="15%" height="35" align="center">'
										+ book.bookname
										+ '</td><td width="15%" height="35" align="center">'
										+ book.bookauthor
										+ '</td><td width="15%" height="35" align="center">'
										+ book.booktype
										+ '</td><td width="10%" height="35" align="center">'
										+ book.bookprice
										+ '</td><td width="15%" height="35" align="center">'
										+ book.bookdate
										+ '</td><td width="15%" height="35" align="center"><button>删除</button></td></tr>');
								$tr.find("button").eq(0).click(function() {
									var sendData = {
										"reqtype" : "delete",
										"bookid" : book.bookid,
										"change" : "change"
									};
									$.post(url, sendData, function(data) {
										if (data.result == true) {
											alert("恭喜您，删除成功！");
											$tr.remove();
										} else {
											alert("对不起，删除失败！");
										}

									}, "json");
								});
								$("#table_book_list").append($tr);
							});

			$tr1 = $('<tr><td colspan="7" height="35" align="center"><span></span><button >首页</button>&nbsp;<button >尾页</button> &nbsp;<button >上一页</button>&nbsp;<button >下一页</button>&nbsp;<select id="selectpage"><option value="2">2</option><option value="5">5</option><option value="10">10</option><option value="50">50</option></select></td></tr>');
			//首页
			$tr1.find("button").eq(0).click(function() {
				sendData = {
					reqtype : "page",
					currentpage : "1",
					pagesize : $("#selectpage").val()
				}
				$.post(url, sendData, function(data) {
					showdata(data);
				}, "json")
			});
			//尾页
			$tr1.find("button").eq(1).click(function() {
				sendData = {
					reqtype : "page",
					currentpage : data.pageUtil.pageCount,
					pagesize : $("#selectpage").val()
				}
				$.post(url, sendData, function(data) {
					showdata(data);
				}, "json")
			});
			//上一页
			$tr1.find("button").eq(2).click(function() {
				sendData = {
					reqtype : "page",
					currentpage : data.pageUtil.currentPage - 1,
					pagesize : $("#selectpage").val()
				}
				$.post(url, sendData, function(data) {
					showdata(data);
				}, "json")
			});
			//下一页
			$tr1.find("button").eq(3).click(function() {
				sendData = {
					reqtype : "page",
					currentpage : data.pageUtil.currentPage + 1,
					pagesize : $("#selectpage").val()
				}
				$.post(url, sendData, function(data) {
					showdata(data);
				}, "json")
			});
			//选择当前页面大小
			$tr1.find("select").eq(0).change(function() {
				var sendData = {
					reqtype : "page",
					pagesize : $("#selectpage").val()
				};
				$.post(url, sendData, function(data) {
					showdata(data);
				}, "json");
			});
			//增加当前页等信息
			$tr1.find("span").eq(0).html(
					"当前页:" + data.pageUtil.currentPage + "&nbsp;&nbsp;共"
							+ data.pageUtil.pageCount + "页&nbsp;" + "共计"
							+ data.pageUtil.totalCount + "条记录&nbsp;");
			$("#table_book_list").append($tr1);
			//设置select选择框为已选择的大小
			$("#selectpage option[value='" + data.pageUtil.pageSize + "']")
					.attr("selected", true);
		}
		function selectp() {
			var size = $
			{
				"size"
			}
			;
			/* $("#selectpage").val(size); */
			/* $.get({
				url:"BookServlet?reqtype=page",
				data:{pagesize:$("#selectpage").val()},
				success:function(data){
					window.location.href='BookServlet?reqtype=pag';
				}
			}); */
		}
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>图书信息列表</h3>
		<table id="table_book_list" width="80%" id="showbook" cellpadding="0"
			cellspacing="0" border="1" bordercolor="#C0C0C0">
			<tr>
				<td width="15%" height="35" align="center">图书编号</td>
				<td width="15%" height="35" align="center">图书名称</td>
				<td width="15%" height="35" align="center">图书作者</td>
				<td width="15%" height="35" align="center">图书类型</td>
				<td width="10%" height="35" align="center">图书价格</td>
				<td width="15%" height="35" align="center">出版日期</td>
				<td width="15%" height="35" align="center">操作</td>
			</tr>
		</table>
	</div>
</body>
</html>