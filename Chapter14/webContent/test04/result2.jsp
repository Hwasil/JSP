<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("utf-8");
%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	
	<body>
		<c:if test="${ empty param.userID }">
			���̵� �Է��ϼ���.<br>
			<a href="login.jsp">�α���â </a>
		</c:if>
		
		<!-- ���̵� �Է����� �� -->
		<c:if test="${ not empty param.userID }">
			<!-- �����ڷ� �α������� �� -->
			<c:if test="${ param.userID == 'admin' }">
				<h1>�����ڷ� �α��� �߽��ϴ�.</h1>
				<form>
					<input tupe="button" value="ȸ������ �����ϱ�"/>
					<input tupe="button" value="ȸ������ �����ϱ�"/>
				</form>
			</c:if>
			<!-- �����ڰ� �ƴ� �� -->
			<c:if test="${ param.userID != 'admin' }">
				<h1>ȯ���մϴ�. <c:out value="${param.userID}"/>��!!</h1>
			</c:if>
		</c:if>
	</body>
</html>