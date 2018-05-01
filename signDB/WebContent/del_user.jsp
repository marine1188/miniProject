<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="jdbc_sign.*" %>
<%
	//삭제하는
    String username = request.getParameter("mb_id");
    Connection conn = null;
    String sql = "DELETE FROM db_sign WHERE mb_id=?";

    try {
        Context init = new InitialContext();
        DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
        conn = ds.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        int result = pstmt.executeUpdate();
        if(result != 0) {
            out.println("삭제 완료");
        }
    } catch(Exception e) {
        out.println("삭제 실패");
        e.printStackTrace();
        return;
    }
    conn.close();
%>
<a href="list_view.jsp">초기화면으로 이동</a>