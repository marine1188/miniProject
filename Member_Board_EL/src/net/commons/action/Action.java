package net.commons.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*액션 관련 클래스는 Action인터페이스를 구현하게 함으로써 요청
 * ActionForward클래스에 포워딩 관련 데이터를 저장하고 ActionForward객체를 리턴하게 처리*/
public interface Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
