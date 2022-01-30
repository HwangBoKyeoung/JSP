package co.hbk.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.hbk.prj.common.Command;

public class LogOut implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String name = (String)session.getAttribute("sessionName");
		
		req.setAttribute("message", name + "님 로그아웃 완료되었습니다.");
		session.invalidate();
				
		return "member/logOut";
	}

}
