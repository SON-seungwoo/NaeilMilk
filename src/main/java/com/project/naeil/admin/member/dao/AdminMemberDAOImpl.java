package com.project.naeil.admin.member.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.project.naeil.member.vo.MemberVO;

@Repository("adminMemberDao")
public class AdminMemberDAOImpl  implements AdminMemberDAO{
	
	//의존성 주입
	@Autowired
	private SqlSession sqlSession;
	
	//회원 목록 조회
	public ArrayList<MemberVO> listMember(HashMap condMap) throws DataAccessException{
		ArrayList<MemberVO>  memberList=(ArrayList)sqlSession.selectList("mapper.admin.member.listMember",condMap);
		return memberList;
	}
	
	//회원 상세 조회
	public MemberVO memberDetail(String member_id) throws DataAccessException{
		MemberVO memberBean=(MemberVO)sqlSession.selectOne("mapper.admin.member.memberDetail",member_id);
		return memberBean;
	}
	
	//회원 수정
	public void modifyMemberInfo(HashMap memberMap) throws DataAccessException{
		sqlSession.update("mapper.admin.member.modifyMemberInfo",memberMap);
	}
	
	//멤버 삭제
	public void deleteMember(String member_id) throws DataAccessException {
		sqlSession.delete("mapper.admin.member.deleteMember",member_id);
	}
	
	
}
