<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
body {
	margin-top: 150px;}
</style>
<title>Insert title here</title>
</head>
<center>
<body>
 <h3>로그인</h3>
	<form action="loginResult.jsp" method="post">
		
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="username"></td>
				
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			
		</table>
		<a href="join.jsp">회원가입</a> 
		<input type="submit" value="로그인">
	</form>
</body>
</center>
</html>