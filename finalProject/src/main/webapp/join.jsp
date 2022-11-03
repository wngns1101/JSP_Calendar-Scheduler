<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="joinAction.jsp" method="post">
		<table border="1">
			<tr><td>아이디</td><td><input type="text" name="joinId"></td></tr>
			<tr><td>비밀번호</td><td><input type="password" name="joinPw"></td></tr>
			<tr><td>이름</td><td><input type="text" name="joinName"></td></tr>
			<tr><td>성별</td><td><input type="text" name="joinGender"></td></tr>
			<tr><td>이메일</td><td><input type="text" name="joinEmail"></td></tr>
			<tr><td colspan="2"><input type="submit" value="회원가입"></td></tr>
		</table>
	</form>
</body>
</html>