<%@ page language="java" contentType="text/html; charset=EUC-KR"
	import="javax.servlet.RequestDispatcher"
    pageEncoding="EUC-KR"%>
    
<% 
	// request ��ü�� setAttribute()�� �̿��� name�� address ���ε�
	request.setAttribute("name", "��ȭ��");
	request.setAttribute("address", "�λ�� ���");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>ù ��° JSP</title>
	</head>
	
	<body>
		<%
			// request ��ü�� �ٸ� JSP ���Ϸ� ������
			RequestDispatcher dispatch = request.getRequestDispatcher("reqTest2.jsp");
			dispatch.forward(request, response);
		%>
	</body>
</html>