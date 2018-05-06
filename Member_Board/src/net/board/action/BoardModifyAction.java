package net.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;
import net.commons.action.Action;
import net.commons.action.ActionForward;

public class BoardModifyAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("euc-kr");
		boolean result=false;
		int num=Integer.parseInt(request.getParameter("BOARD_NUM"));
		String id = request.getParameter("BOARD_ID");
		BoardDAO boarddao = new BoardDAO();
		BoardBean boarddata = new BoardBean();

		boolean usercheck=boarddao.isBoardWriter(num, id);		
		if(!(id.equals("MASTER"))){
			if(usercheck==false){
				response.setContentType("text/html;charset=euc-kr");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정할 권한이 없습니다.');");
				out.println("location.href='./BoardList.bo';");
				out.println("</script>");
				out.close();
				return null;
			}
		}		
		try{		
			boarddata.setBOARD_NUM(num);
			boarddata.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
			boarddata.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
			result= boarddao.boardModify(boarddata);
			if(result==false){
				System.out.println("게시판 수정 실패");
				return null;
			}
			System.out.println("게시판 수정 완료");
			forward.setRedirect(true);
			forward.setPath("./BoardDetailAction.bo?num="+boarddata.getBOARD_NUM());
			return forward;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}