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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>삭제</title>
</head>
<body class="container">
<jsp:include page="header.jsp"/>
    <c:if test="${deleteResult == 0}">
		<script>
			alert('비워진 항목이 있습니다. 다시 입력해주세요');
		</script>
	</c:if>
    <c:if test="${deleteResult == 1}">
		<script>
			alert('삭제에 실패했습니다. 다시 입력해주세요');
		</script>
	</c:if>
    <c:if test="${deleteResult == 2}">
		<script>
			alert('삭제할 일정이 없습니다. 다시 입력해주세요');
		</script>
	</c:if>
    <div class="jumbotron">
        <h1>일정 삭제</h1>
        <p>일정 삭제 화면입니다.</p>
    </div>
	<form action="delete.do" method="post">
			<label>삭제할 제목 </label><br>
			<input type="text" name="calTitle"><br>
			<label>삭제 날짜</label><br>
		<input type="date" name="calDeleteDate"><br>
			<input type="submit" value="삭제" class="btn btn-primary">
	</form>
	<jsp:include page="footer.jsp"/>
</body>
</html>