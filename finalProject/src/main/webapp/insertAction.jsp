<%@page import="java.util.Calendar"%>
<%@page import="calendar.calDAO"%>
<%@page import="calendar.calDTO"%>
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
 	calDTO dto = new calDTO();
	calDAO dao = new calDAO();
	
	String str[] = request.getParameter("calStartDate").split("-");
	int mm = Integer.parseInt(str[1]); 
			
	dto.setCalName(request.getParameter("calName"));
	dto.setCalId((String)session.getAttribute("userInfoId"));
 	dto.setCalTitle(request.getParameter("calTitle"));
 	dto.setCalStartDate(request.getParameter("calStartDate"));
 	dto.setCalEndDate(request.getParameter("calEndDate"));
 	dto.setCalText(request.getParameter("calText"));

 	if(dto.getCalId() == null || dto.getCalName() == null || dto.getCalTitle() == null || dto.getCalStartDate() == null || dto.getCalEndDate() == null || dto.getCalText() == null){
		out.println("<script>");
		out.println("alert('비워진 항목이 있습니다.')");
		out.println("history.back()");
		out.println("</script>");
	}else{
		int result = dao.calInsert(dto, mm);	
		if(result == -1){
			out.println("<script>");
			out.println("alert('등록에 실패했습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}else{
			out.println("<script>");
			out.println("alert('등록에 성공했습니다.')");
			out.println("location.href='index.jsp'");
			out.println("</script>");
		}
	}
%>


</body>
</html>