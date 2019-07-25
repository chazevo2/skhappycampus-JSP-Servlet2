<%@ page import="com.work.model.Member"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<header>
		<a href="logout">로그아웃</a>
		<a href="myInfo">마이페이지</a>
		|| 아이디 : <%= session.getAttribute("memberId") %> || 등급 : <%= session.getAttribute("grade") %>
<%
	if(session.getAttribute("grade").equals("A")) {
%>
		[관리자]<a href="memberList">전체회원 조회</a>
<%
	}
%>
	</header>
	<hr>
<% 
	ArrayList<Member> list = (ArrayList<Member>) request.getAttribute("list"); 
%>
	<h3>회원목록</h3>
	<div>
		<table>
		<tr><th>아이디</th><th>비밀번호</th><th>이름</th><th>휴대폰</th><th>이메일</th><th>가입일</th><th>등급</th><th>마일리지</th><th>담당자</th><th>삭제</th></tr>
<%
	for(Member m : list) {
%>
		<tr><td><%= m.getMemberId() %></td>
			<td><%= m.getMemberPw() %></td>
			<td><%= m.getMemberName() %></td>
			<td><%= m.getMobile() %></td>
			<td><%= m.getEmail() %></td>
			<td><%= m.getEntryDate() %></td>
			<td><%= m.getGrade() %></td>
			<td><%= m.getMileage() %></td>
	<%
		if(m.getManager() != null) {
	%>
			<td><%= m.getManager() %></td>
	<%
		} else {
	%>
			<td>미배정</td>
	<%
		}
	%>
			<td><a href="delMember?memberId=<%= m.getMemberId() %>">강퇴</a></td>
		</tr>
<%
	}
%>
		</table>
	</div>
</body>
</html>