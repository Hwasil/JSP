<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, sec01.ex01.*" pageEncoding="UTF-8" 
    isELIgnored="false"  %>
<% request.setCharacterEncoding("UTF-8"); %>   

<!-- 회원 정보를 저장한 빈을 생성 -->
<jsp:useBean id="m1" class="sec01.ex01.MemberBean" />
<!-- 전송된 회원정보를 빈의 속성에 설정 -->
<jsp:setProperty name="m1" property="*" />
<jsp:useBean id="membersList" class="java.util.ArrayList" />
<jsp:useBean id="membersMap" class="java.util.HashMap" />

<%
	// membersMap에 회원정보를 key와 value로 저장
	membersMap.put("id", "park2");
	membersMap.put("pwd", "4321");
	membersMap.put("name", "박지성");
	membersMap.put("eamil", "park2@test.com");

	MemberBean m2 = new MemberBean("son", "1234", "손흥민", "son@test.com");
	membersList.add("m1");
	membersList.add("m2");
	membersMap.put("membersList", membersList);
%>

<html>
	<head>
		<meta charset=”UTF-8">
		<title>회원 정보 출력창</title>
	</head>
	<body>
		<table border="1"  align="center" >
		    <tr align="center" bgcolor="#99ccff">
		      <td width="20%"><b>아이디</b></td>
		      <td width="20%"><b>비밀번호</b></td>
		      <td width="20%"><b>이름</b></td>
		      <td width="20%"><b>이메일</b></td>
		   </tr>
		   <tr align=center>  
		  		<!-- 인덱스가 0이므로 첫번째 회원 정보를 출력-->
		      <td>${membersMap.id} </td>
		      <td>${membersMap.pwd} </td>
		      <td>${membersMap.name} </td>
		      <td>${membersMap.eamil} </td> 
		   </tr>   
		   <tr align=center>  
		  		<!-- 인덱스가 0이므로 첫번째 회원 정보를 출력-->
		      <td>${membersMap.memberList[0].id} </td>
		      <td>${membersMap.memberList[0].pwd} </td>
		      <td>${membersMap.memberList[0].name} </td>
		      <td>${membersMap.memberList[0].eamil} </td> 
		   </tr>   
		   <tr align=center>
		   		<!-- 빈 id와 속성 이름을 접근해 회원정보 출력 -->
		      <td>${membersMap.memberList[1].id } </td>
		      <td>${membersMap.memberList[1].pwd } </td>
		      <td>${membersMap.memberList[1].name } </td>
		      <td>${membersMap.memberList[1].email } </td>
		   </tr>
		</table>
	</body>
</html>
