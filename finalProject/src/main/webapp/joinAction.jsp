<%@page import="user.userDAO"%>
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
	userDAO dao = new userDAO();
	user.setId(request.getParameter("joinId"));
	user.setPassword(request.getParameter("joinPw"));
	user.setName(request.getParameter("joinName"));
	user.setGender(request.getParameter("joinGender"));
	user.setEmail(request.getParameter("joinEmail"));
	
	if(user.getId() == null || user.getPassword() == null|| user.getName() == null || user.getGender() == null || user.getEmail() == null){
		out.println("<script>");
		out.println("alert('비워진 항목이 있습니다.')");
		out.println("history.back()");
		out.println("</script>");
	}else{
		int result = dao.join(user);	
		if(result == -1){
			out.println("<script>");
			out.println("alert('이미 존재하는 아이디입니다.')");
			out.println("history.back()");
			out.println("</script>");
		}else{
			out.println("<script>");
			out.println("alert('회원가입에 성공했습니다.')");
			out.println("location.href='login.jsp'");
			out.println("</script>");
		}
	}
%>
</body>
</html>