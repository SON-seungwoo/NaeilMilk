package com.project.naeil.admin.member.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.project.naeil.member.vo.MemberVO;

public interface AdminMemberService {
	
	//회원 목록 조회
	public ArrayList<MemberVO> listMember(HashMap condMap) throws Exception;
	
	//회원 상세 조회
	public MemberVO memberDetail(String member_id) throws Exception;
	
	//회원 수정
	public void  modifyMemberInfo(HashMap memberMap) throws Exception;
	
	//멤버 삭제
	public void removeMember(String member_id) throws Exception;
}