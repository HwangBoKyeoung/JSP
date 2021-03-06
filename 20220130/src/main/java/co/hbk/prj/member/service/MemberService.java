package co.hbk.prj.member.service;

import java.util.List;

import co.hbk.prj.member.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> memberList();
	public MemberVO memberSelect(MemberVO vo);
	public int memberInsert(MemberVO vo);
	public int memberDelete(MemberVO vo);
	public int memberUpdate(MemberVO vo);
	
	public boolean isIdCheck(String id);
}
