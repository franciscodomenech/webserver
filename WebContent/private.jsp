<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,java.util.ArrayList,model.ItemMenu,model.ITabla"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
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
	
	<div>
		<table>
			<%
				List<ITabla> tabla = (List<ITabla>) request.getAttribute("table");
				for(int i=0;i<tabla.size();i++){
					List<String> row = tabla.get(i).getCampos();
				%>
					<tr>
						<%for(int j=0; j<row.size(); j++){%>
						<td>
							<%=row.get(j) %>
						</td>
						<%} %>
					</tr>
				<%
				}
			%>
		</table>
	</div>
</body>
</html>