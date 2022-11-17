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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body class="container">
    <div class="jumbotron">
        <h1>삭제</h1>
        <p>삭제 화면입니다.</p>
    </div>
	<form action="deleteAction.jsp">
			<label>삭제할 제목 </label><br>
			<input type="text" name="calTitle"><br>
			<label>삭제 날짜</label><br>
		<input type="date" name="calDeleteDate"><br>
			<input type="submit" value="삭제" class="btn btn-primary">
	</form>
</body>
</html>