package co.micol.prj.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	
	void noticeHitUpdate(int id);	//조회수증가
//	전달인자가 2개 이상일 경우, 파라미터 annotation을 사용해줘야함(Mapper에서 해당되는 부분=>xml에서 사용해야하기 때문)
	List<NoticeVO> noticeSearch(@Param("key") String key, @Param("str") String str);	//검색할 필드와 데이터를 전달받아 search하기
}
