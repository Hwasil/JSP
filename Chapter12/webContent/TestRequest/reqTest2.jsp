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
		<title>�� ��° JSP</title>
	</head>
	
	<body>
		<h1>�̸��� <%= name %>�Դϴ�</h1>
		<h1>�ּҴ� <%= address %>�Դϴ�</h1>
	</body>
</html>