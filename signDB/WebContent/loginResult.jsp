<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="jdbc_sign.*" %>

<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
    Connection conn = null;
    String sql = "SELECT mb_pw, grade, email FROM db_sign WHERE mb_id=?";
    try {
        Context init = new InitialContext();
        DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
        conn = ds.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()) {
            if(password.equals(rs.getString(1))) {
                session.setAttribute("mb_id", username);
                session.setAttribute("grade",  rs.getString(2));
                response.sendRedirect("list_view.jsp");
            }
        }
    } catch(Exception e) {
        e.printStackTrace();
        return;
    }
    conn.close();
%>
로그인 실패
<a href="login.jsp">초기화면으로 이동</a>