<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 페이지</title>
</head>
<body>
	<header>
		<a href="hi"> hello 서블릿</a>
		<a href="lifeCycle">서블릿 라이프사이클</a>
		<a href="dispatcher">디스패치</a>
		<a href="index.jsp">메인</a>
		<a href="login.jsp">로그인</a>
		<a href="signup.jsp">회원가입</a>
		<a href="findMember.jsp">아이디/비밀번호 찾기</a>
	</header>
	<hr>
	<h3>오류 메세지</h3>
	<div id="error_page"><%= request.getAttribute("message") %></div>
</body>
</html>