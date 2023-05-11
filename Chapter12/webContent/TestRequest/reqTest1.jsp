<%@ page language="java" contentType="text/html; charset=EUC-KR"
	import="javax.servlet.RequestDispatcher"
    pageEncoding="EUC-KR"%>
    
<% 
	// request 객체에 setAttribute()를 이용해 name과 address 바인딩
	request.setAttribute("name", "오화실");
	request.setAttribute("address", "부산시 사상구");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>첫 번째 JSP</title>
	</head>
	
	<body>
		<%
			// request 객체를 다른 JSP 파일로 포워딩
			RequestDispatcher dispatch = request.getRequestDispatcher("reqTest2.jsp");
			dispatch.forward(request, response);
		%>
	</body>
</html>