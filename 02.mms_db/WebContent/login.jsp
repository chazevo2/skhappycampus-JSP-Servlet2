<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
</head>
<body>
	<header>
		<a href="login.jsp">로그인</a>
		<a href="signup.jsp">회원가입</a>
		<a href="findMember.jsp">아이디/비밀번호 찾기</a>
	</header>
	<hr>
	<h3>로그인</h3>
	<form action="login" method="post">
		<div>
			<input type="text" name="memberId" placeholder="ID" pattern="^[a-zA-Z0-9]*$" required autofocus>
		</div>
		<div>
			<input type="password" name="memberPw" placeholder="Password" pattern="^[a-zA-Z0-9]*$" required>
		</div>
		<div>
			<input type="submit" value="로그인">
			<input type="reset" value="취소">
		</div>
	</form>
</body>
</html>