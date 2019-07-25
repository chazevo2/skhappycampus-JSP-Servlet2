<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>에러페이지</h1>
<h3>예외클래스명 : <%= exception.getClass().getName() %></h3>
<h3>예외 메세지 : <%= exception.getMessage() %></h3>
</body>
</html>