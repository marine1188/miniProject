<%@page import="net.member.db.MemberBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%
	List memberlist=(List)request.getAttribute("memberlist");
%>
<html>
<head><title>목록(유저)_관리자</title></head>
<body>
<center>
<table boarder=1 width=300>
	<tr align=center><td colspan=2>회원목록</td></tr>
	<%for(int i=0 ; i<memberlist.size() ; i++){ 
		MemberBean member=(MemberBean)memberlist.get(i);
	%>
	<tr align=center> 
		<td><a href="MemberViewAction.me?id=<%=member.getMEMBER_ID() %>">
					<%=member.getMEMBER_ID() %></a></td>
		<td><a href="MemberDeleteAction.me?id=<%=member.getMEMBER_ID() %>">
				삭제</a></td>		
	</tr>
	<%} %>
	
	<tr align = center>
		<td colspan="2"> <a href="./BoardList.bo">[게시판 이동]</a> </td>
	</tr>
</table>
</center>
</body>
</html>