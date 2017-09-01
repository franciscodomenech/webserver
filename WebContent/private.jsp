<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList" %> 
<%@page import="model.MenuItem"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul>
	
	<% 
	ArrayList<MenuItem> menu = (ArrayList<MenuItem>)request.getAttribute("menu");
	for(int i=0;i<menu.size();i++){ %>
	<li><a href="private?op=<%=i%>"><%= menu.get(i).getNombreItem() %></a></li>
	<% } %>
	</ul>
	<div>${requestScope['op']}</div> 
</body>
</html>