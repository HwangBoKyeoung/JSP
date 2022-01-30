package co.hbk.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.hbk.prj.common.Command;
import co.hbk.prj.member.service.MemberService;
import co.hbk.prj.member.serviceImpl.MemberServiceImpl;
import co.hbk.prj.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		HttpSession session = req.getSession(true);

		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPassword(password);
		
		MemberService service = new MemberServiceImpl();
		vo = service.memberSelect(vo);
		
		if(vo!=null) {
			session.setAttribute("sessionId", vo.getId());
			session.setAttribute("sessionName", vo.getName());
			req.setAttribute("message", vo.getName() + "님 환영합니다.");
		} else {
			req.setAttribute("message", "아이디 또는 비밀번호가 일치하지않습니다.");
		}

		return "member/login";
	}

}
