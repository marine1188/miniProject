<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="jdbc_sign.*" %>

<%
	String username = request.getParameter("mb_name");
	String password = request.getParameter("mb_pw");
    Connection conn = null;
    String sql = "SELECT mb_pw, grade, email FROM db_sign WHERE mb_name=?";

    try {
        Context init = new InitialContext();
        DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
        conn = ds.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()) {
            if(password.equals(rs.getString(1))) {
                session.setAttribute("username", username);
                session.setAttribute("grade",  rs.getString(2));
                response.sendRedirect("view_list.jsp");
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