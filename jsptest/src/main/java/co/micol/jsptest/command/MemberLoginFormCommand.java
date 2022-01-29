package co.micol.jsptest.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.jsptest.common.Command;

public class MemberLoginFormCommand implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
//		단순 로그인 폼 호출
		return "member/memberLoginForm";
	}

}
