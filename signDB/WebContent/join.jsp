<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>회원 가입 페이지</title>
<meta charset="utf-8">
<style type="text/css">
table {
	border-collapse: collapse;
	border: #819FF7 1px solid;
}
</style>
<script src="sign_up.js">
    
    </script>
</head>
<body onLoad="init()">
	<form action="1control.jsp" 
		method="POST">
		<table border="1" align="center" cellpadding="5">
			<tr>
				<td colspan="2" align="center" bgcolor="#CED8F6"><b>회원 기본
						정보</b></td>
			</tr>
			<tr>
				<td align="center" bgcolor="#EEEEEE"><b>아이디:</b></td>
				<td><input type="text" id="mb_id" name="mb_id" size="12">
					4~12자의 영문 대소문자와 숫자로만 입력</td>
			</tr>
			<tr>
				<td align="center" bgcolor="#EEEEEE"><b>비밀번호: </td>
				<td><input type="password" id="mb_pw" name="mb_pw" size="12">
					4~12자의 영문 대소문자와 숫자로만 입력</td>
			</tr>
			<tr>
				<td align="center" bgcolor="#EEEEEE"><b>비밀번호 확인</b></td>
				<td><input type="password" id="mb_pw2" size="12"></td>
			</tr>
			<tr>
				<td align="center" bgcolor="#EEEEEE"><b>메일주소:</b></td>
				<td><input type="text" id="email" name="email" size="18">
					예) id@domain.com</td>
			</tr>
			<tr>
				<td align="center" bgcolor="#EEEEEE"><b>이름:</b></td>
				<td><input type="text" name="mb_name" id="mb_name" size="18">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" bgcolor="#CED8F6"><b>개인 신상
						정보</b></td>
			</tr>
			<tr>
				<td align="center" bgcolor="#EEEEEE"><b>주민등록번호:</b></td>
				<td><input type="text" id="jumin1" name="jumin1" size="8"
					maxlength="6"> - <input type="password" id="jumin2"
					name="jumin2" size="8" maxlength="7" onBlur="setBirthDay()">
					예) 700101-1******</td>
			</tr>
			<tr>
				<td align="center" bgcolor="#EEEEEE"><b>생일:</b></td>
				<td><input type="text" name="birth_year" id="birth_year"
					size="4" maxlength="4">년 <select name="birth_month"
					id="birth_month">
						<option value="1" selected="selected">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
				</select>월 <select name="birth_date" id="birth_date">
						<option value="1" selected="selected">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
				</select>일</td>
			</tr>
			<tr>
				<td align="center" bgcolor="#EEEEEE"><b>관심분야:</b></td>
				<td><input type="checkbox" name="interest" value="computer">컴퓨터
					<input type="checkbox" name="interest" value="internet">인터넷
					<input type="checkbox" name="interest" value="travel">여행
					<input type="checkbox" name="interest" value="movie">영화감상
					<input type="checkbox" name="interest" value="music">음악감상
				</td>
			</tr>
			<tr>
				<td align="center" bgcolor="#EEEEEE"><b>자기소개:</b></td>
				<td><textarea name="introduce" cols="50" rows="6"></textarea></td>
			</tr>
		</table>
		<p align="center">
			<input type="submit" value="회원 가입"> <input type="reset"
				value="다시입력">
		</p>
	</form>
</body>
</html>