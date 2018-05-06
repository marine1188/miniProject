package net.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.commons.action.Action;
import net.commons.action.ActionForward;
import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberLoginAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession(); //회원 인증 성공시 아이디를 세션에 등록할 세션 객체 생성
		MemberDAO memberdao = new MemberDAO();
		MemberBean member = new MemberBean();
		
		int result=-1; // 기본 결과 값을 -1(아이디가 존재하지 않는다는 의미로 정의)
		/*로그인폼에서 입력한 값을 memberbean객체에 저장*/
		member.setMEMBER_ID(request.getParameter("MEMBER_ID"));
		member.setMEMBER_PW(request.getParameter("MEMBER_PW"));
		result=memberdao.isMember(member); //dao에 ismember메소드호출하여 회원인증
		
		//로그인 실패의 경우
		if(result==0){ //비밀번호 틀리다는 결과값 나오면 얼럿창 띄우고 다시 로그인창
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.');");
			out.println("location.href='./MemberLogin.me';");
			out.println("</script>");
			out.close();
			return null;
		}else if(result==-1){ //아이디가 존재하지 않으면 경고얼럿창 후 다시 로그인창
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디가 존재하지 않습니다.');");
			out.println("location.href='./MemberLogin.me';");
			out.println("</script>");
			out.close();
			return null;
		}		
		
		//로그인 성공의 경우
		session.setAttribute("id", member.getMEMBER_ID()); //세션에 id등록
		forward.setRedirect(true);//접속끊었다가 다시연결하면서 새로운 정보를 보여준다.
		forward.setPath("./BoardList.bo"); //게시판 목록 보기 요청.
		return forward;
	}
}
