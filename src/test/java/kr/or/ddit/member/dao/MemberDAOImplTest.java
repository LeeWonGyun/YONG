package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.vo.MemberVO;

public class MemberDAOImplTest {
	
	MemberDAO dao = new MemberDAOImpl();
	

	@Test
	public void testSelectMemberForAuth() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectMemberList() {
		List<MemberVO> memberList = dao.selectMemberList(pagingVO);
		assertNotNull(memberList);
		assertNotEquals(0, memberList.size()); //0 이 아닌지 확인하겠다.
	}

	@Test
	public void testSelectMember(String memId) {
		MemberVO detail = dao.selectMember(memId);
		assertNotNull(detail);
	}

	@Test
	public void testUpdateMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteMember() {
		fail("Not yet implemented");
	}

}
