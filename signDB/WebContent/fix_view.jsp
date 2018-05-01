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
<body>
	<%
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		
		Connection conn = null;
		String sql = "UPDATE db_sign SET mb_pw =? , email =? WHERE mb_id=?";

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,pw);
			pstmt.setString(2,email);
			pstmt.setString(3,(String)session.getAttribute("mb_id"));
			ResultSet rs = pstmt.executeQuery();
			out.println("수정 성공 하였습니다.");
		} catch (Exception e) {
			out.println("데이터 가져오기 실패하였습니다.");
			e.printStackTrace();
			return;
		}

		conn.close();
	%>
</html>