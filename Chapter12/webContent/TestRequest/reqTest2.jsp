<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<% 
	String name = (String)request.getAttribute("name");
	String address = (String)request.getAttribute("address");
%>

<html>
	<head>
		<meta charset="EUC-KR">
		<title>두 번째 JSP</title>
	</head>
	
	<body>
		<h1>이름은 <%= name %>입니다</h1>
		<h1>주소는 <%= address %>입니다</h1>
	</body>
</html>