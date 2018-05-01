<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<center>
		<form action="fix_view.jsp" method="post">
			<table border="1" cellpadding="5">

				<tr>
					<td>비밀번호</td>
					<td><input type="text" name="pw"></td>
				</tr>
				<tr>
					<td>메일</td>
					<td><input type="text" name="email"></td>
				</tr>


			</table>
			<input type="submit" value="수정">

		</form>
	</center>
</body>

</html>