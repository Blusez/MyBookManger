<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上订餐后台- 管理页面</title>
</head>
<frameset  rows="64,*"  frameborder="0"  framespacing="0">
   <frame  src="top.jsp" name="topFrame" frameborder="1"  scrolling="0" target="main" />
   <frameset cols="200,*" id="frame">
	<frame src="left.jsp" name="leftFrame" frameborder="1" scrolling="0" target="main" />
	<frame src="right.jsp" name="main" frameborder="1" scrolling="0" target="_self" />
  </frameset>  
</frameset>
<noframes>
  <body></body>
</noframes> 

</html>