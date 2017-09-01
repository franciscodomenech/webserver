<%@page  import="model.*" %>
<%@page  import="java.util.ArrayList;" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul>
    <% 
		ArrayList<ItemMenu> menu = (ArrayList<ItemMenu>) request.getAttribute("menu");
    for(int i=0; i<menu.size(); i++){
    %>
    	<li> <a href="private?op=<%=menu.get(i).getOp() %>"><%=menu.get(i).getName() %></a></li>
    <%
    }
	%>
    
    </ul>
</body>
</html>