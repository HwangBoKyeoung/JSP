package co.hbk.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.hbk.prj.common.Command;

public class Main implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		return "main/main";
	}

}
