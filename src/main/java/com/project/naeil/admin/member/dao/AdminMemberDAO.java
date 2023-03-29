package com.project.naeil.admin.member.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.dao.DataAccessException;

import com.project.naeil.member.vo.MemberVO;

public interface AdminMemberDAO {
	
	//회원 목록 조회
	public ArrayList<MemberVO> listMember(HashMap condMap) throws DataAccessException;
	
	//회원 상세 조회
	public MemberVO memberDetail(String member_id) throws DataAccessException;
	
	//회원 정보 조회
	public void modifyMemberInfo(HashMap memberMap) throws DataAccessException;
	
	//멤버 삭제
	public void deleteMember(String member_id) throws DataAccessException;
}