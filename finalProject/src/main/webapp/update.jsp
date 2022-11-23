<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<c:if test="${updateResult == 0}">
		<script>
			alert('비워진 항목이 있습니다. 다시 등록해주세요');
		</script>
	</c:if>
    <c:if test="${updateResult == 1}">
		<script>
			alert('등록에 실패했습니다. 다시 등록해주세요');
		</script>
	</c:if>
	<div class="jumbotron">
		<h1>일정 수정</h1>
        <p>일정 수정 화면입니다.</p>
	</div>
	<form action="update.do" method="post">
		<label>수정할 일정</label><br>
		<input type="text" name="calOldTitle"><br>
		<label>제목</label><br>
		<input type="text" name="calTitle"><br>
		<label>시작 날짜</label><br>
		<input type="date" name="calStartDate"><br>
		<label>끝나는 날짜</label><br>
		<input type="date" name="calEndDate"><br>
		<label>내용</label><br>
		<textarea name="calText"></textarea><br>
		<input type="submit" value="수정" class="btn btn-primary">
	</form>
</body>
</html>