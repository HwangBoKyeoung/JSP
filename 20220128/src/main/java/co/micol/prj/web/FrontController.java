package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.command.Login;
import co.micol.prj.command.LoginForm;
import co.micol.prj.command.Logout;
import co.micol.prj.command.MainCommand;
import co.micol.prj.command.NoticeList;
import co.micol.prj.command.NoticeSelect;
import co.micol.prj.command.NoticeWriter;
import co.micol.prj.command.NoticeWriterForm;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = null;
       
    public FrontController() {
        super();
    }

//  명령그룹
	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String, Command>();
		
		map.put("/main.do", new MainCommand());	//Home Page
		
		map.put("/loginForm.do", new LoginForm());
		map.put("/login.do", new Login());
		map.put("/logout.do", new Logout());
		
		map.put("/noticeList.do", new NoticeList());
		map.put("/noticeSelect.do", new NoticeSelect());
		map.put("/noticeWriterForm.do", new NoticeWriterForm());
		map.put("/noticeWriter.do", new NoticeWriter());
	}
	
//	서비스요청분석 및 실행
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page);	//요청에 따른 적절한 command를 찾아주는 역할
		String viewPage = command.exec(request, response);
		
		if(viewPage != null && !viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
