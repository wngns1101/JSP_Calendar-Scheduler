<%@page import="calendar.calDAO"%>
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
		calDAO dao = new calDAO();
		String title = request.getParameter("calTitle");
		String id = (String)session.getAttribute("userInfoId");
	
		if(title == null){
			out.println("<script>");
			out.println("alert('제목을 입력하지 않으셨습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}else{
			int result = dao.calDelete(id, title);	
			if(result == -1){
				out.println("<script>");
				out.println("alert('삭제에 실패했습니다.')");
				out.println("history.back()");
				out.println("</script>");
			}else if(result == 0){
				out.println("<script>");
				out.println("alert('삭제할 일정이 없습니다.')");
				out.println("location.href='index.jsp'");
				out.println("</script>");
			}else{
				out.println("<script>");
				out.println("alert('삭제에 성공했습니다.')");
				out.println("location.href='index.jsp'");
				out.println("</script>");
			}
		}
		
	%>
	
	
</body>
</html>