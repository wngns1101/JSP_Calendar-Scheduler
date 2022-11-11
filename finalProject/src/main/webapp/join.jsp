<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body class="container">
    <div class="jumbotron">
        <h1>회원가입</h1>
        <p>회원가입 화면입니다.</p>
    </div>
    
	<form action="joinAction.jsp" method="post">
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