<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (session.getAttribute("userInfoId") == null) {
		response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body class="container">
	<div class="jumbotron">
		<h1>수정</h1>
		<p>수정 화면입니다.</p>
	</div>
	<form action="updateAction.jsp">
		<label>수정할 일정</label><br>
		<input type="text" name="calOldTitle"><br>
		<label>제목</label><br>
		<input type="text" name="calTitle"><br>
		<label>시작 날짜</label><br>
		<input type="date" name="calStartDate"><br>
		<label>끝나는 날짜</label><br>
		<input type="date" name="calEndDate"><br>
		<label>내용</label><br>
		<textarea name="calText"></textarea>
		<input type="submit" value="수정" class="btn btn-primary">
	</form>
</body>
</html>