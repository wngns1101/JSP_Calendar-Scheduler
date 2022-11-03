<%@page import="user.userDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	userDTO user = new userDTO();
	user.setId(request.getParameter("joinId"));
	user.setPassword(request.getParameter("joinPw"));
	user.setName(request.getParameter("joinName"));
	user.setGender(request.getParameter("joinGender"));
	user.setEmail(request.getParameter("joinEmail"));
%>
</body>
</html>