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
import co.micol.prj.command.LoginForm;
//import co.micol.prj.command.Button;
import co.micol.prj.command.MainCommand;
//import co.micol.prj.command.TableCommand;
import co.micol.prj.command.RegisterForm;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String,Command> map = null;
       
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String, Command>();
		
		map.put("/main.do", new MainCommand());
		map.put("/loginForm.do", new LoginForm());	
		map.put("/registerForm.do", new RegisterForm());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String page = uri.substring(context.length());
		
		Command command = map.get(page);
		String viewPage = command.exec(request, response);
		
		if(viewPage!=null && !viewPage.endsWith(".do")) {
			viewPage = viewPage + ".tiles";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

}
