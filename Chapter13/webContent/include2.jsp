<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>include.jsp : ��ȭ��</title>
	</head>
	
	<body>
		�ȳ��ϼ���. JSP ���θ� ���� �κ��Դϴ�. 
		<br>
		<jsp:include page="duke_image.jsp" flush="true">
			<jsp:param value="��ũ2" name="name"/>
			<jsp:param value="duke2.png" name="imgName"/>
		</jsp:include>
		<br>
		JSP ���θ� �� �κ��Դϴ�.
	</body>
</html>