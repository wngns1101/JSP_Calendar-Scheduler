<%@page import="calendar.calInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	calInfo info = new calInfo();	
%>
	<jsp:include page="header.jsp"/>
	
	<form action="indexAction.jsp">
		<table border="1">
			<tr>
			<th> <input type="radio" name="date" value="<%=info.calDate(0)%>"><%=info.calDate(0)%></th>
			<th> <input type="radio" name="date" value="<%=info.calDate(1)%>"><%=info.calDate(1)%></th>
			<th> <input type="radio" name="date" value="<%=info.calDate(2)%>"><%=info.calDate(2)%></th>
			<th> <input type="radio" name="date" value="<%=info.calDate(3)%>"><%=info.calDate(3)%></th>
			<th> <input type="radio" name="date" value="<%=info.calDate(4)%>"><%=info.calDate(4)%></th>
			<th> <input type="radio" name="date" value="<%=info.calDate(5)%>"><%=info.calDate(5)%></th>
			<th> <input type="radio" name="date" value="<%=info.calDate(6)%>"><%=info.calDate(6)%></th>
			<th> <input type="submit" value="확인"/></th>
		</tr>
		</table>
	</form>
	<jsp:include page="footer.jsp"/>
</body>
</html>
	