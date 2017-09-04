<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.ItemMenu,model.Cliente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ejemplo WebServer</title>
	<style>
		table * {
			border: 1px solid gray;
		}
		
		table{
			 border-spacing: 0px;
   			 border-collapse: collapse;
		}
		thead *{
			font-weight: bold;
		}
		tbody *{
			font-weight: normal;
		}
	</style>
</head>
<body>
	<div id="menu">
		<ul>
		
		<%
		List<ItemMenu> menu = (List<ItemMenu>)request.getAttribute("menu");
		for(int i=0;i<menu.size();i++){
			ItemMenu it = menu.get(i);
		%>
		<li><a href="private?op=<%=it.getOp()%>"><%=it.getName()%></a></li>
		<% } %>
		</ul>
	</div>
	<div id="tabla">
	
	<% 
	List<String> columns=(List<String>) request.getAttribute("columns");
	List<List<String>> table=(List<List<String>>) request.getAttribute("table");
	%>
		<table>
			 <thead>
				  <tr>
				  <%
				  	for(int i=0; i<columns.size(); i++ ){
				  %>
				     <th><%= columns.get(i) %></th>
				  <%
				  	}
				  %>
				  </tr>
			 </thead>
			 <tbody>
				  <%
				  	for(int i=0; i<table.size(); i++ ){
				  %>
				     <tr>
					  <%
					  	for(int j=0; j<table.get(i).size(); j++ ){
					  %>
					     <th><%= table.get(i).get(j) %></th>
					  <%
					  	}
					  %>
				     </tr>
				  <%
				  	}
				  %>
			 </tbody>
		</table>
	</div>
</body>
</html>