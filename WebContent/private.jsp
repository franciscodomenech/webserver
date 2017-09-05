<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.ItemMenu,model.RowTable"%>
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
	<div>
	<table>
	<%
	String[] titles = (String[])request.getAttribute("columns");
	RowTable[] table = (RowTable[])request.getAttribute("table");
	%>
		<thead>
			<tr>
			<%
			for(int i=0;i<titles.length;i++)
				out.println("<th>"+titles[i]+"</th>");
			%>
			</tr>
		</thead>
		<tbody>
			<%
			for(int i=0;i<table.length;i++){
				out.println("<tr>");
				RowTable row = table[i];
				List<String> cols = row.get_cols();
				for(int j=0;j<cols.size();j++)
					out.println("<td>"+cols.get(j)+"</td>");
				out.println("</tr>");
			}
			%>
		</tbody>
	</table>
	</div>
</body>
</html>