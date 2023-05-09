<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
 	request.setCharacterEncoding("utf-8");
	int dan = Integer.parseInt(request.getParameter("dan"));
	%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>구구단 출력창</title>
	</head>
	
	<body>
		<table border="1" width="160">
			<tr align=center bgcolor="FFFF66">
				<td colspan = "2"><%= dan %>단 출력 </td>
			</tr>
			<%
				for (int i=0; i<10; i++) {
			%>
				<tr align = "center">
					<td width="80">
						<%= dan %> * <%= i %> 
					</td>
					<td width="80">
						<%= i * dan %> 
					</td>
				</tr>
			<% 
				} 
			%>
		</table>
	</body>
</html>