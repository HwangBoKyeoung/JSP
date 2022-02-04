package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;
import co.micol.prj.notice.vo.NoticeVO;

public class NoticeSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("noticeId");
		
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
//		vo.setNoticeId(Integer.parseInt(id));
		vo.setNoticeId(Integer.valueOf(id));
		
		vo = noticeDao.noticeSelect(vo);
//		request.setAttribute("notice", noticeDao.noticeSelect(vo));
		
		if(vo!=null) {
			noticeDao.noticeHitUpdate(vo.getNoticeId());	//읽은 후 조회수 증가
			request.setAttribute("notice", vo);
		} else {
			request.setAttribute("message", "조회된 데이터가 없습니다.");
			return "notice/noticeError";
		}
		
		return "notice/noticeSelect";
	}

}
