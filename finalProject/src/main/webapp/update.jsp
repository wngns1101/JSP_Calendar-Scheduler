<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<h1>삭제</h1>
		<p>삭제 화면입니다.</p>
	</div>
	<form action="updateAction.jsp">
		<label>이름</label><br>
		<input type="text" name="calName"><br>
		<label>제목</label><br>
		<input type="text" name="calTitle"><br>
		<label>시작날짜</label><br>
		<input type="date" name="calStartDate"><br>
		<label>끝나는날짜</label><br>
		<input type="date" name="calEndDate"><br>
		<label>내용</label><br>
		<textarea name="calText"></textarea>
		<input type="submit" value="수정" class="btn btn-primary">
	</form>
</body>
</html>