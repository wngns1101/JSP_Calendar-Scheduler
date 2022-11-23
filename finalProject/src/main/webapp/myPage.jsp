<%@page import="java.util.ArrayList"%>
<%@page import="calendar.calDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Insert title here</title>
</head>
<body class="container">
    <div class="jumbotron">
        <h1>마이페이지</h1>
        <p>내 일정입니다.</p>
    </div>
    <table>
<%
	String totalScadular[][];
	totalScadular = dao.calMyDate((String)session.getAttribute("userInfoId"));
	
	for(int i=0; i<totalScadular.length; i++){
		out.println("<tr><td>");
		out.println(totalScadular[i][0] +"</td>");
		out.println("<td>");
		out.println(totalScadular[i][1] +"</td>");
		out.println("<td>");
		out.println(totalScadular[i][2] +"</td>");
		out.println("<td>");
		out.println(totalScadular[i][3] +"</td>");
		out.println("<td>");
		out.println(totalScadular[i][4] +"</td>");
		out.println("<td>");
		out.println(totalScadular[i][5] +"</td>");
		out.println("</tr>");
	}
%>
    </table>
</body>
</html>