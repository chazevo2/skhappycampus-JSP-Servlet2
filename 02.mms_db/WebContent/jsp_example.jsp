<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error2.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 기본 예제</title>
</head>
<body>
<!-- 정의어 태그 : 멤버변수, 메서드 선언, JSP lifecycle 메서드 재정의 -->
<%!
	// 멤버변수
	public String courseName = "2019 행복성장캠퍼스";

	public void jspInit() {
		System.out.println("\n### jspInit() JSP 페이지 초기화 수령 ");
	}
	
	public void jspDestroy() {
		System.out.println("\n### jspDestroy() JSP 페이지 자원해제 수령 ");
	}
%>

<!-- -jspService() {} 구현부 코드로 자동변환되는 코드 -->
<h3>과정명 : <%= courseName %></h3>
<ul>
<%
	int total = 0;
	for(int i = 1; i <= 10; i++) {
		if(i%3 == 0) {
			total += i;
%>
	<li><%= i %></li>
<%
		}
	}
%>
</ul>
<h3>총합 : <%= total %></h3>
<h3>나누기 결과 : <%= total/0 %></h3>
</body>
</html>