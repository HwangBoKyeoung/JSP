package co.hbk.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.hbk.prj.command.LogOut;
import co.hbk.prj.command.Login;
import co.hbk.prj.command.LoginForm;
import co.hbk.prj.command.Main;
import co.hbk.prj.common.Command;

@WebServlet("*.do")
public class FrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	HashMap<String, Command> map = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String, Command>();
		
		map.put("/main.do", new Main());
		map.put("/loginForm.do", new LoginForm());
		map.put("/login.do", new Login());
		map.put("/logout.do", new LogOut());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page);
		String viewPage = command.exec(req, resp);
		
		if(viewPage != null && !viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
	}
}
