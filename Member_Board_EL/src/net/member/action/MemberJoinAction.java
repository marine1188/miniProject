package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.commons.action.Action;
import net.commons.action.ActionForward;
import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberJoinAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("euc-kr"); 
		
		ActionForward forward = new ActionForward();
		MemberBean member = new MemberBean();
		MemberDAO memberdao = new MemberDAO();
				
		boolean result=false;
		/*MEMBERBEAN에 입력값 담기*/
		member.setMEMBER_ID(request.getParameter("MEMBER_ID"));
		member.setMEMBER_PW(request.getParameter("MEMBER_PW"));
		member.setMEMBER_NAME(request.getParameter("MEMBER_NAME"));
		member.setMEMBER_AGE(Integer.parseInt(request.getParameter("MEMBER_AGE")));
		member.setMEMBER_GENDER(request.getParameter("MEMBER_GENDER"));
		member.setMEMBER_EMAIL(request.getParameter("MEMBER_EMAIL"));
		/*DAO에 joinmember 실행해서 회원가입처리		*/
		result=memberdao.joinMember(member); 

		/*가입실패면 NULL*/
		if(result==false){
			System.out.println("회원가입 실패");
			return null;
		}	
		//회원가입 성공
		forward.setRedirect(true);
		forward.setPath("./MemberLogin.me");		
		return forward;
	}
}
