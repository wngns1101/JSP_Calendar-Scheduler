<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>로그인</title>
</head>
<body class="container">
	<c:if test="${loginResult == 0}">
		<script>
			alert('비밀번호가 일치하지 않습니다. 다시 입력해주세요');
		</script>
	</c:if>
	<c:if test="${loginResult == 1}">
		<script>
			alert('id가 존재하지 않습니다. 다시 입력해주세요');
		</script>
	</c:if>
    <c:if test="${loginResult == 2}">
		<script>
			alert('데이터베이스 오류입니다. 다시 입력해주세요');
		</script>
	</c:if>
    <div class="jumbotron">
        <h1>로그인</h1>
        <p>로그인 화면입니다.</p>
    </div>
    
	<form action="login.do" method="post">
		 <div class="form-group">
			<label>아이디</label><br>
			<input type="text" name="loginId">
		</div>
		<div class="form-group">
			<label>비밀번호</label><br>
			<input type="password" name="loginPw">
		</div>
		<input type="submit" value="로그인" class="btn btn-primary"> <button type="button" onclick="location.href='join.jsp'" class="btn btn-primary">회원가입</button>
	</form>
</body>
</html>      