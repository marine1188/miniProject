<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jdbc_sign.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
table {c
	
}
</style>

<title>회원 상세정보</title>
</head>
<center>
	<body>
		<%  // been에 저장 되어 있는것을 불러온다  백터 공간을 만들어준다
    Vector<MemberBean> listMember = null;
    listMember = new Vector<MemberBean>(); //초기화
    Connection conn = null;
    String sql = "SELECT * FROM db_sign";
    //jdbc 연결 
    try {
        Context init = new InitialContext();
        DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
        conn = ds.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            MemberBean tmpBean = new MemberBean();
            tmpBean.setMb_id(rs.getString(1));
            tmpBean.setMb_name(rs.getString(4));
            listMember.add(tmpBean);
        }
    } catch(Exception e) {
        out.println("데이터 가져오기 실패하였습니다.");
        e.printStackTrace();
        return;
    }

    conn.close();
%>

		<% if(session.getAttribute("grade").equals("1")) { %>

		<h2>회원 관리</h2>
		<table border="1">
			<tr>
				<th>이름</th>
				<th>아이디</th>
				<th colspan="2">메뉴</th>
			</tr>
			<%
        for(int i = 0; i < listMember.size(); i++) {
    %>
			<tr>
				<td><%= listMember.get(i).getMb_name()%></td>
				<td><%= listMember.get(i).getMb_id()%></td>
				<td><a
					href="del_user.jsp?mb_id=<%= listMember.get(i).getMb_id()%>">삭제</a></td>
				<td><a
					href="detail_view.jsp?mb_id=<%= listMember.get(i).getMb_id()%>">보기</a></td>
			</tr>
			</table>
			<%
    }
} else {
%>

			<a href="detail_view.jsp?mb_id=<%= session.getAttribute("mb_id") %>">내
				정보 보기</a>
			<br>

			<a href="fix_form.jsp">수정</a>
			<br>

			<%
}%>
		
		<a href="kill.jsp">로그아웃</a>
	</body>
</center>
</html>