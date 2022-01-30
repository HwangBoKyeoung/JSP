package co.hbk.prj.member.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.hbk.prj.common.DataSource;
import co.hbk.prj.member.service.MemberMapper;
import co.hbk.prj.member.service.MemberService;
import co.hbk.prj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class);

	@Override
	public List<MemberVO> memberList() {
		return map.memberList();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		return map.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		return map.memberInsert(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		return map.memberDelete(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		return map.memberUpdate(vo);
	}

	@Override
	public boolean isIdCheck(String id) {
		return map.isIdCheck(id);
	}
	
}
