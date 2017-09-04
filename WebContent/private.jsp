<%@page import="java.util.ArrayList"%>
<%@page import="javax.sql.RowSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="utils.ItemValue"
	import="java.util.ArrayList" import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<%
			ArrayList<ItemValue> menu = (ArrayList<ItemValue>) request.getAttribute("menu");
			for (ItemValue it : menu) {
		%>
		<li><a id="<%=it.get_item()%>"><%=it.get_value()%></a></li>
		<%
			}
		%>
		<%
			//for para mostrar articulos o usuarios.
		%>
	</ul>
	<div id="contenido">${requestScope['menu']}
		<br />
		<%
			if (request.getAttribute("list") != null) {
				ArrayList<ArrayList<String>> list = (ArrayList<ArrayList<String>>) request.getAttribute("list");
		%>
		<table>
			<thead>
				<tr>
					<%
						for (String col : list.get(0)) {
					%>
					<td><%=col%></td>

					<%
						}
					%>
				</tr>
			</thead>

			<tbody>
				<%
					for (int i = 1; i < list.size(); i++) {
				%>
				<tr>
					<%
						for (String col : list.get(i)) {
					%>
					<td><%=col%></td>
					<%
						}
					%>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<%
			}
		%>
	</div>
</html>