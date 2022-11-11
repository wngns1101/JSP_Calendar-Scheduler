<%@page import="java.util.ArrayList"%>
<%@page import="calendar.calDAO"%>
<%@page import="calendar.calInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<jsp:include page="header.jsp"/>
<body class="container">
    <%
		calInfo info = new calInfo();	
		String date = request.getParameter("date");
		calDAO dao = new calDAO();
	%>
    <div class="jumbotron">
        <h1>메인페이지</h1>
        <p><%=date %> 일정입니다.</p>
    </div>
    
	
	
	<form action="indexAction.jsp">
		<table class="table table-striped">
			<tr>
			<td> <input type="radio" name="date" value="<%=info.calDate(0)%>"><%=info.calDate(0)%></td>
			<td> <input type="radio" name="date" value="<%=info.calDate(1)%>"><%=info.calDate(1)%></td>
			<td> <input type="radio" name="date" value="<%=info.calDate(2)%>"><%=info.calDate(2)%></td>
			<td> <input type="radio" name="date" value="<%=info.calDate(3)%>"><%=info.calDate(3)%></td>
			<td> <input type="radio" name="date" value="<%=info.calDate(4)%>"><%=info.calDate(4)%></td>
			<td> <input type="radio" name="date" value="<%=info.calDate(5)%>"><%=info.calDate(5)%></td>
			<td> <input type="radio" name="date" value="<%=info.calDate(6)%>"><%=info.calDate(6)%></td>
			<td> <input type="submit" value="확인" class="btn btn-primary"/></td>
		</tr>
		<tr>
			
			<%
				ArrayList<String> list1 = new ArrayList<String>(dao.calDate(date));
				int size = 0;
				for(int i=0; i<list1.size(); i++){
				if(size == 6){
			%>
			</tr>
			<tr>
			<%
				size = 0;
				}
			%>
			<td>
			
				<%=list1.get(i)%>
				
			</td>
			<%
				size++;
				}
			%>
		</tr>
		</table>
				<button type="button" onclick="location.href='insert.jsp'" class="btn btn-primary">추가</button>
				<button type="button" onclick="location.href='update.jsp'" class="btn btn-primary">수정</button>
				<button type="button" onclick="location.href='delete.jsp'" class="btn btn-primary">삭제</button>
	</form>
	<jsp:include page="footer.jsp"/>
</body>
</html>