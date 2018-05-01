<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%
	//한글 깨짐 방지 코드
	request.setCharacterEncoding("UTF-8");

	String act = request.getParameter("act");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="3; url=login.jsp"></meta>
<title>제어하는곳</title>
</head>
<body>
	<%
		Connection conn = null;

		String mb_id = request.getParameter("mb_id");
		String mb_pw = request.getParameter("mb_pw");
		String email = request.getParameter("email");
		String mb_name = request.getParameter("mb_name");
		String jumin1 = request.getParameter("jumin1");
		String jumin2 = request.getParameter("jumin2");
		String birth_year = request.getParameter("birth_year");
		String birth_month = request.getParameter("birth_month");
		String birth_date = request.getParameter("birth_date");
		String interest[] = request.getParameterValues("interest");
		String introduce = request.getParameter("introduce");

		String interestBuf = "";

		for (int i = 0; i < interest.length; i++) {
			if (i == interest.length - 1) {
				interestBuf += interest[i].toString();
				break;
			}
			interestBuf += interest[i].toString() + ",";
		}

		String sql = "INSERT INTO db_sign VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,'0' )";

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mb_id);
			pstmt.setString(2, mb_pw);
			pstmt.setString(3, email);
			pstmt.setString(4, mb_name);
			pstmt.setString(5, jumin1);
			pstmt.setString(6, jumin2);
			pstmt.setString(7, birth_year);
			pstmt.setString(8, birth_month);
			pstmt.setString(9, birth_date);
			pstmt.setString(10, interestBuf);
			pstmt.setString(11, introduce);

			if (pstmt.executeUpdate() != 0) {
				out.println("회원등록 완료! ");
			}
		} catch (Exception e) {
			out.println("회원등록 실패! ");
			e.printStackTrace();
		}
	%>
	<%!public boolean checkID(String mb_id) {
		String sql = "SELECT mb_id FROM db_sign WHERE mb_id=" + mb_id;

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			if (pstmt.executeUpdate() != 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}%>

</body>
</html>