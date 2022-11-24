<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="calendar.calDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if (session.getAttribute("userInfoId") == null) {
    response.sendRedirect("login.jsp");
	}
	Calendar cal = Calendar.getInstance();
	int mm = cal.get(Calendar.MONTH) + 1;

	if(mm == 13){
		mm = 1;
	}

	if(mm == 0){
		mm = 12;
	}
	calDAO dao = new calDAO();
	String day = request.getParameter("date");
	ArrayList<String> list = new ArrayList<String>(dao.dayScheduler(day, mm));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>상세화면</title>
</head>
<jsp:include page="header.jsp"/>
<body class="container">
    <div class="jumbotron">
        <h1>일정</h1>
        <p><%=day %> 일정들입니다.</p>
    </div>
    <table class="table table-striped">
    <tr>
    <%
    for(int j=0; j<list.size(); j++){
   		if(j % 6 == 0){
   			out.println("</tr><tr>");
   		}
   		out.println("<td>"+list.get(j)+"<td>");
    }
   	%>
   	<tr>
    </table>
	
<jsp:include page="footer.jsp"/>
</body>
</html>