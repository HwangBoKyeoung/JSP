package co.micol.jsptest.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.jsptest.common.Command;

public class MemberSignFormCommand implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
//		회원가입 폼 페이지로 이동
		return "member/memberSignForm";
	}

}
