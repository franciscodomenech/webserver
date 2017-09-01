
<%@page import="model.ItemMenu"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Área Privada</title>

</head>

<body>

	<ul>

	

	<%
	
	ArrayList<ItemMenu> menu = (ArrayList<ItemMenu>)request.getAttribute("menu");
	
	for(int i=0;i<menu.size();i++){
		ItemMenu it = menu.get(i);
	%>

	<li><a href="private?op=<%=it.getOp()%>">Opcion <%=it.getName()%></a></li>


	<% 
		//System.out.println(it.getOp());
	
	} %>
	</ul>

	<div>${requestScope['op']}</div>

</body>

</html>