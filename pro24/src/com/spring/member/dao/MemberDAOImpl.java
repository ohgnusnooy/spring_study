package com.spring.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;


public class MemberDAOImpl implements MemberDAO {
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List selectAllMemberList() throws DataAccessException {//setter 구현
		List<MemberVO> membersList = null;
		membersList = sqlSession.selectList("mapper.member.selectAllMemberList");//sqlSession 빈으로 selectList() 메서드를 호출하면서 SQL문의 id를 전달
		return membersList;
	}

	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {//sqlSession 빈으로 insert() 메서드를 호출하면서 SQL문의 id와 memberVO를 전달
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		return result;
	}

	@Override
	public int deleteMember(String id) throws DataAccessException {//sqlSession 빈으로 delete() 메서드를 호출하면서 SQL문의 id와 회원 id를 전달
		int result =  sqlSession.delete("mapper.member.deleteMember", id);
		return result;
	}
}
