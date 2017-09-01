<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.ItemMenu"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul>
	
	<%
	List<ItemMenu> menu = (List<ItemMenu>)request.getAttribute("menu");
	for(int i=0;i<menu.size();i++){
		ItemMenu it = menu.get(i);
	%>
	<li><a href="private?op=<%=it.getOp()%>"><%=it.getName()%></a></li>
	<% } %>
	</ul>
	<div></div>
</body>
</html>