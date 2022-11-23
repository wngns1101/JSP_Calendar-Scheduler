<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body class="container">
	<c:if test="${joinResult == 2}">
		<script>
			alert('아이디가 중복입니다. 다시 입력해주세요');
		</script>
	</c:if>
	<c:if test="${joinResult == 0}">
		<script>
			alert('빈 항목이 있습니다. 다시 입력해주세요');
		</script>
	</c:if>
    <c:if test="${joinResult == 1}">
		<script>
			alert('이미 존재하는 아이디입니다. 다시 입력해주세요');
		</script>
	</c:if>
    <div class="jumbotron">
        <h1>회원가입</h1>
        <p>회원가입 화면입니다.</p>
    </div>
    
	<form action="join.do" method="post">
		<div class="form-group">
			<label>아이디</label><br>
			<input type="text" name="joinId">
		</div>
		<div class="form-group">
			<label>비밀번호</label><br>
			<input type="password" name="joinPw">
		</div>
		<div class="form-group">	
			<label>이름</label><br>
			<input type="text" name="joinName">
		</div>
		<div class="form-group">	
			<label>성별</label>
			<input type="radio" name="joinGender" value="남자"> 남자<input type="radio" name="joinGender" value="여자">여자
		</div>
		<div class="form-group">
			<label>이메일</label><br>
			<input type="text" name="joinEmail">
		</div>
			<input type="submit" value="회원가입" class="btn btn-primary">
	</form>
</body>
</html>