<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<% 
	String name = (String)session.getAttribute("name");
	String address = (String)application.getAttribute("address");
%>

<html>
	<head>
		<meta charset="EUC-KR">
		<title>���� ��ü ������ �׽�Ʈ2</title>
	</head>
	
	<body>
		<h1>�̸��� <%= name %>�Դϴ�</h1>
		<h1>�ּҴ� <%= address %>�Դϴ�</h1>
	</body>
</html>