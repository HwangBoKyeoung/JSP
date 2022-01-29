package co.micol.jsptest;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.jsptest.command.ACommand;
import co.micol.jsptest.command.BCommand;
import co.micol.jsptest.command.MemberJoinCommand;
import co.micol.jsptest.command.MemberListCommand;
import co.micol.jsptest.command.MemberLoginCommand;
import co.micol.jsptest.command.MemberLoginFormCommand;
import co.micol.jsptest.command.MemberSearchCommand;
import co.micol.jsptest.command.MemberSignFormCommand;
import co.micol.jsptest.common.Command;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Command> map = null;
   
    public FrontController() {
        super();
    }

//  초기값 등록
	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String, Command>();
		
		map.put("/a.do", new ACommand());
		map.put("/b.do", new BCommand());
		
		map.put("/memberList.do", new MemberListCommand());
		map.put("/memberSearch.do", new MemberSearchCommand());
		map.put("/memberLoginForm.do", new MemberLoginFormCommand());
		map.put("/memberLogin.do", new MemberLoginCommand());
		map.put("/memberSignForm.do", new MemberSignFormCommand());
		map.put("/memberJoin.do", new MemberJoinCommand());
	}

//	실제 서비스 동작
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//한글깨짐방지
		response.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page);
		String viewPage = command.run(request, response);
		
//		간단한 viewResolve => 서버에서 접근하기 위함
		if(viewPage!=null && !viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		
//		서버에서 접근 => 브라우저로 결과를 돌림
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
