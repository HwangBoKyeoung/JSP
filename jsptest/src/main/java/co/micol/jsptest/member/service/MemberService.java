package co.micol.jsptest.member.service;

import java.util.List;

public interface MemberService {
	List<MemberVO> memberSelectList();	//전체리스트 R
	MemberVO memberSelect(MemberVO vo);	//한 건조회 R
	int memberInsert(MemberVO vo);		//삽입 C
	int memberUpdate(MemberVO vo);		//삭제 D
	int memberDelete(MemberVO vo);		//수정 U
}
