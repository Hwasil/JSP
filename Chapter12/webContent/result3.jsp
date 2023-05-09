<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8"); // 글자 깨질 시
	String id = request.getParameter("user_id");
	String pw = request.getParameter("user_pw");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 결과</title>
	</head>
	
	<body>
		<h1>로그인 결과 출력</h1>
		<%
			if (id == null || id.length() == 0) {
		%>
				아이디를 입력하세요!<br>
				<a href="/Chapter12/login.html">로그인하기</a>
		<%
			} else if (id.equals("admin")) {	
		%>
				<h1>관리자로 로그인 했습니다.</h1>
				<form>
					<input type=button value="회원정보 삭제하기">
					<input type=button value="회원정보 수정하기">
				</form>
		<%
			} else {
		%>
				<h2><%= id %>님 환영합니다!</h2>
		<% 
			}
		%>
	</body>
</html>