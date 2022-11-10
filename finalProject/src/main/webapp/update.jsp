<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateAction.jsp">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="calName"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="calTitle"></td>
			</tr>
			<tr>
				<td>시작날짜</td>
				<td><input type="date" name="calStartDate"></td>
			</tr>
			<tr>
				<td>끝나는날짜</td>
				<td><input type="date" name="calEndDate"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="calText"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정"></td>
			</tr>
		</table>
	</form>
</body>
</html>