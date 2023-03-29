package com.project.naeil.admin.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface AdminMemberController {
	
	//메인 회원 
	public ModelAndView adminGoodsMain(@RequestParam Map<String, String> dateMap,HttpServletRequest request, HttpServletResponse response)  throws Exception;
	
	//회원 상세 조회
	public ModelAndView memberDetail(HttpServletRequest request, HttpServletResponse response)  throws Exception;
	
	//회원 수정
	public void modifyMemberInfo(HttpServletRequest request, HttpServletResponse response)  throws Exception;
	//public ModelAndView deleteMember(HttpServletRequest request, HttpServletResponse response)  throws Exception;
	
	//회원 삭제
	public void deleteMember(@RequestParam("member_id") String member_id, HttpServletRequest request, HttpServletResponse response)  throws Exception;
}