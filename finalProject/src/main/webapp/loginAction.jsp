<%@page import="user.userDAO"%>
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
		String id = request.getParameter("loginId");
		String pw = request.getParameter("loginPw");
	
		userDAO dao = new userDAO();
		int result = dao.login(id, pw);
		
		if(result == 1){
			out.println("<script>");
			out.println("alert('로그인에 성공했습니나.')");
			session.setAttribute("userInfoId", id);
			out.println("location.href='index.jsp'");
			out.println("</script>");
		}else if(result == 0){
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}else if(result == -1){
			out.println("<script>");
			out.println("alert('id가 존재하지 않습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}else{
			out.println("<script>");
			out.println("alert('데이터베이스 오류입니다')");
			out.println("history.back()");
			out.println("</script>");
		}
	%>
	
</body>
</html>