package co.micol.prj.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;
import co.micol.prj.notice.vo.NoticeVO;

public class NoticeWriter implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {		
		String writer = request.getParameter("writer");
		String date = request.getParameter("date");
		String title = request.getParameter("title");
		String subject = request.getParameter("subject");
		
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeWriter(writer);
		vo.setNoticeDate(Date.valueOf(date));
		vo.setNoticeTitle(title);
		vo.setNoticeSubject(subject);
		
		String viewPage = null;
		
		if(noticeDao.noticeInsert(vo)!=0) {
			viewPage = "noticeList.do";
		} else {
			request.setAttribute("message", "등록이 실패했습니다.");
			viewPage = "notice/noticeError";
		}
		
		return viewPage;
	}

}
