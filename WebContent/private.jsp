
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

	

	<% for(int i=0;i<3;i++){ %>

	<li><a href="private?op=<%=i%>">Opción <%=i%></a></li>

	<% } %>

	</ul>

	<div>${requestScope['op']}</div>

</body>

</html>