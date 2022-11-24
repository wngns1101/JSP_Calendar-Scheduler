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
<title>추가</title>
</head>
<body class="container">
<jsp:include page="header.jsp"/>
	<c:if test="${insertResult == 0}">
		<script>
			alert('비워진 항목이 있습니다. 다시 등록해주세요');
		</script>
	</c:if>
    <c:if test="${insertResult == 1}">
		<script>
			alert('등록에 실패했습니다. 다시 등록해주세요');
		</script>
	</c:if>
    <div class="jumbotron">
        <h1>일정 추가</h1>
        <p>일정 추가 화면입니다.</p>
    </div>
	<form action="insert.do" method="post">
			<label>이름</label><br>
			 <input type="text" name="calName"><br>
			<label>제목</label><br>
			 <input type="text" name="calTitle"><br>
			<label>시작날짜</label> <br>
			<input type="date" name="calStartDate"><br>
			<label>끝나는날짜</label><br>
			 <input type="date" name="calEndDate"><br>
			<label>내용</label><br>
			 <textarea name="calText"></textarea><br>
			<input type="submit" value="추가" class="btn btn-primary">
	</form>
	<jsp:include page="footer.jsp"/>
</body>
</html>