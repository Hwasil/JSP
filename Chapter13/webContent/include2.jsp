<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>include.jsp : 오화실</title>
	</head>
	
	<body>
		안녕하세요. JSP 쇼핑몰 시작 부분입니다. 
		<br>
		<jsp:include page="duke_image.jsp" flush="true">
			<jsp:param value="듀크2" name="name"/>
			<jsp:param value="duke2.png" name="imgName"/>
		</jsp:include>
		<br>
		JSP 쇼핑몰 끝 부분입니다.
	</body>
</html>