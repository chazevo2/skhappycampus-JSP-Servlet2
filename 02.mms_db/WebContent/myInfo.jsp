<%@page import="com.work.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyInfo</title>
</head>
<body>
	<header>
		<a href="login.jsp">로그인</a>
		<a href="signup.jsp">회원가입</a>
	</header>
	<hr>
	<%
		Member m = (Member) request.getAttribute("member");
	%>
	<h3>내정보조회</h3>
	<form action="#" method="post">
		<div>
			아이디 : <input type="text" name="memberId" value="<%= m.getMemberId() %>" pattern="^[a-zA-Z0-9]*{6,12}$" readonly>
		</div>
		<div>
			비밀번호 : <input type="password" name="memberPw" value="<%= m.getMemberPw() %>" pattern="^[a-zA-Z0-9]*{8,12}$" required>
		</div>
		<div>
			성명 : <input type="text" name="memberName" value="<%= m.getMemberName() %>" pattern="^[가-힣]*{2,3}$" required>
		</div>
		<div>
			전화번호 : <input type="tel" name="mobile" value="<%= m.getMobile() %>" pattern="^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$" required>
		</div>
		<div>
			이메일 : <input type="text" name="email" value="<%= m.getEmail() %>" pattern="^[a-zA-Z0-9]+@[a-zA-Z]+.[a-zA-Z]{2,3}$" required>
		</div>
		<div>
			가입일 : <input type="text" name="entry_date" value="<%= m.getEntryDate() %>" pattern="^\d{4}.\d{2}.\d{2}$" required readonly>
		</div>
		<div>
			등급 : <input type="text" name="grade" value="<%= m.getGrade() %>" pattern="^[AGS]{1}$" required readonly>
		</div>
		<div>
			마일리지 : <input type="text" name="mileage" value="<%= m.getMileage() %>" pattern="^\d{1,6}$" required readonly>
		</div>
		<div>
			매니저 : <input type="text" name="manager" value="<%= m.getManager() %>" pattern="^[가-힣]*{2,3}$" required readonly>
		</div>
		<div>
			<input type="submit" value="회원가입">
		</div>
	</form>
</body>
</html>