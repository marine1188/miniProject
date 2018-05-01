<!-- 로그아웃 페이지  / 세션을 죽인다 -->

<%
    session.invalidate();
    response.sendRedirect("login.jsp");
%>