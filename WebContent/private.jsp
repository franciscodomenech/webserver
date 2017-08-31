<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	tipo: ${requestScope['user']._tipo}.
	id: ${requestScope['user']._id}.
	
	<ul>
		<li><a href=/private?id=0>opcion 1</a></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
	
	
</body>
</html>