<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!-- 선언문 작성 -->
<%! 
	String name = "오화실";
	public String getName() {
		return name;
	}
%>

<!-- 스트립트릿 작성 -->
<%
	String age = request.getParameter("age");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>선언문 연습 - 오화실</title>
	</head>
	<body>
					<!-- 표현식 -->
		<h1>안녕하세요.  <%= name %>님!</h1>
		<h2>당신의 나이는 <%= age %>살 입니다.</h2>
	</body>
</html>