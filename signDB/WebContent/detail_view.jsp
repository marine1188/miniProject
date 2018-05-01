<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="jdbc_sign.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 상세정보</title>
</head>
<center>
<body>
	<!-- 빈에 저장되어 있는 값을 불러온다 -->
	<%!MemberBean memberBean = new MemberBean();%>
	<%
		String username = request.getParameter("mb_id");
		Connection conn = null;
		String sql = "SELECT * FROM db_sign WHERE mb_id=?";

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				memberBean.setMb_id(rs.getString(1));
				memberBean.setMb_pw(rs.getString(2));
				memberBean.setEmail(rs.getString(3));
				memberBean.setMb_name(rs.getString(4));
				memberBean.setJumin1(rs.getString(5));
				memberBean.setJumin2(rs.getString(6));
				memberBean.setBirth_year(rs.getString(7));
				memberBean.setBirth_month(rs.getString(8));
				memberBean.setBirth_date(rs.getString(9));
				memberBean.setInterest(rs.getString(10));
				memberBean.setIntroduce(rs.getString(11));
				memberBean.setGrade(rs.getString(12));
			}
		} catch (Exception e) {
			out.println("데이터 가져오기 실패하였습니다.");
			e.printStackTrace();
			return;
		}

		conn.close();
	%>
 <h3> 내 정보 보기 </h3>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><%=memberBean.getMb_id()%></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%=memberBean.getMb_pw()%></td>
		</tr>
		<tr>
			<td>등급</td>
			<td>
				<%
					if (memberBean.getGrade() == "1")
						out.print("관리자");
					else
						out.print("사용자");
				%>
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><%=memberBean.getEmail()%></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=memberBean.getMb_name()%></td>
		</tr>
		<tr>
			<td>주민등록번호 앞자리</td>
			<td><%=memberBean.getJumin1()%></td>
		</tr>
		<tr>
			<td>주민등록번호 뒷자리</td>
			<td><%=memberBean.getJumin2()%></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><%=memberBean.getBirth_year() + "년 " + memberBean.getBirth_month() + "월 " + memberBean.getBirth_date()
					+ "일"%></td>
		</tr>
		<tr>
			<td>관심분야</td>
			<td><%=memberBean.getInterest()%></td>
		</tr>
		<tr>
			<td>자기소개</td>
			<td><%=memberBean.getIntroduce()%></td>
		</tr>
	</table>
</body>
</center>
</html>