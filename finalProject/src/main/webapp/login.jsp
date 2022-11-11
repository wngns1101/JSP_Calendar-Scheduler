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
        <h1>로그인</h1>
        <p>로그인 화면입니다.</p>
    </div>
    
	<form action="loginAction.jsp" method="post">
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