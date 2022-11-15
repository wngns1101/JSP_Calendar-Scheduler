<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="calendar.calDAO"%>
<%@page import="calendar.calInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%

Calendar cal = Calendar.getInstance();

int yy = cal.get(Calendar.YEAR);
int mm = cal.get(Calendar.MONTH) + 1;

if(mm == 13){
	mm = 1;
	yy++;
}

if(mm == 0){
	mm = 12;
	yy--;
}

int w = calInfo.weekDay(yy, mm, 1);
int lastday = calInfo.lastDay(yy, mm);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body class="container">
<jsp:include page="header.jsp"/>
    <div class="jumbotron">
        <h1>메인페이지</h1>
    </div>
    
<%!
	calDAO indexDao = new calDAO();
%>

		<table class="table table-striped">
			<tr>
		<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
	</tr>
	<tr>
<%
for(int i=1; i<w; i++){
	out.println("<td></td>");
}
	for(int i=1; i<=lastday; i++){
		w = calInfo.weekDay(yy, mm, i);
		out.println("<td>"+i+"<br>"+indexDao.+"</td>");
		if(w == 7){
			out.println("</tr>");
			if(i < lastday){
				out.println("<tr>");
			}
		}
	}
	if(w != 7){
		for(int i=w; i<7; i++){
			out.println("<td>&nbsp;</td>");
		}	
		out.println("</tr>");
	}
%>
		</table>
			<button type="button" onclick="location.href='insert.jsp'" class="btn btn-primary">추가</button>
			<button type="button" onclick="location.href='update.jsp'" class="btn btn-primary">수정</button>
			<button type="button" onclick="location.href='delete.jsp'" class="btn btn-primary">삭제</button>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>
	