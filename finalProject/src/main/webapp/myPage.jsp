<%@page import="java.util.ArrayList"%>
<%@page import="calendar.calDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	if (session.getAttribute("userInfoId") == null) {
		response.sendRedirect("login.jsp");
	}
	calDAO dao = new calDAO();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body class="container">
<jsp:include page="header.jsp"/>
    <div class="jumbotron">
        <h1>마이페이지</h1>
        <p>내 일정입니다.</p>
    </div>
    <table class="table table-striped">
	<tr>
<%
	ArrayList<String> data =(ArrayList<String>) request.getAttribute("data");
	
	for(int i=0; i<data.size(); i++){
		if(i % 6 == 0){
			out.println("</tr><tr>");
		}
		out.println("<td>"+data.get(i)+"</td>");
	}
%>
</table>
<jsp:include page="footer.jsp"/>
</body>
</html>