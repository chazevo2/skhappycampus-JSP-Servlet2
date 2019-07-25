<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signup</title>
</head>
<body>
	<header>
		<a href="login.jsp">로그인</a>
		<a href="signup.jsp">회원가입</a>
		<a href="findMember.jsp">아이디/비밀번호 찾기</a>
	</header>
	<hr>
	<h3>회원가입</h3>
	<form action="signup" method="post">
		<div>
			아이디 : <input type="text" name="memberId" placeholder="ID" pattern="^[a-zA-Z0-9]*{6,12}$" required autofocus>
		</div>
		<div>
			비밀번호 : <input type="password" name="memberPw" placeholder="Password" pattern="^[a-zA-Z0-9]*{8,12}$" required>
		</div>
		<div>
			성명 : <input type="text" name="memberName" placeholder="Name" pattern="^[가-힣]*{2,3}$" required>
		</div>
		<div>
			전화번호 : <input type="tel" name="mobile" placeholder="Tel(010-0000-0000)" pattern="^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$" required>
		</div>
		<div>
			이메일 : <input type="text" name="email" placeholder="Email(user@work.com)" pattern="^[a-zA-Z0-9]+@[a-zA-Z]+.[a-zA-Z]{2,3}$" required>
		</div>
		<div>
			<input type="submit" value="회원가입">
		</div>
	</form>
</body>
</html>