package net.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.board.db.BoardDAO;
import net.commons.action.Action;
import net.commons.action.ActionForward;

public class BoardDeleteAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("euc-kr");
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id"); //세션에 저장되어 있는 아이디를 id변수에 저장한다.
		
		boolean result=false;
		int num=Integer.parseInt(request.getParameter("num")); //삭제할 글 번호를 num 변수에 저장한다.
		
		BoardDAO boarddao = new BoardDAO();
		boolean usercheck=boarddao.isBoardWriter(num, id); //dao 클래스의 isBoardWriter()메소드에 전달한다.
		if(!(id.equals("MASTER"))){
			if(usercheck==false){ // 글쓴이가 아닐 경우 경고 메시지를 띄운 후 게시판 메인 페이지로 이동.
				response.setContentType("text/html;charset=euc-kr");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제할 권한이 없습니다.');");
				out.println("location.href='./BoardList.bo'");
				out.println("</script>");
				out.close();
				return null;
			}
		}
		result=boarddao.boardDelete(num);
	
		if(result==false){ //글 삭제 실패할 경우 null
			System.out.println("게시판 삭제 실패");
			return null;
		}
		//글 삭제 성공할때 게시판 메인 페이지로 이동
		System.out.println("게시판 삭제 성공");
		forward.setRedirect(true);
		forward.setPath("./BoardList.bo");
		return forward;
	}
}