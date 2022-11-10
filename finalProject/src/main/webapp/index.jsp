<%@page import="java.util.ArrayList"%>
<%@page import="calendar.calDAO"%>
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
	calDAO indexDao = new calDAO();
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
		<tr>
			<td><%=info.calDate(0) %> 일정입니다.</td>
		</tr>
		<tr>
			
			<%
				ArrayList<String> list2 = new ArrayList<String>(indexDao.calDate(info.calDate(0)));
				int size = 0;
				for(int i=0; i<list2.size(); i++){
				if(size == 6){
			%>
			</tr>
			<tr>
			<%
				size = 0;
				}
			%>
			<td>
			
				<%=list2.get(i)%>
				
			</td>
			<%
				size++;
				}
			%>
		</tr>
		<tr>
			<td>
				<button type="button" onclick="location.href='insert.jsp'">추가</button>
			</td>
			<td>
				<button type="button" onclick="location.href='update.jsp'">수정</button>
			</td>
			<td>
				<button type="button" onclick="location.href='delete.jsp'">삭제</button>
			</td>
		</tr>
		</table>
	</form>
	<jsp:include page="footer.jsp"/>
</body>
</html>
	