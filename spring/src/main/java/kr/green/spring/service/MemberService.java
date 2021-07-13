package kr.green.spring.service;

import javax.servlet.http.HttpServletRequest;

import kr.green.spring.vo.MemberVO;

public interface MemberService {

	MemberVO signin(MemberVO user);

	void signup(MemberVO user);

	MemberVO getMember(HttpServletRequest r);
	

	
}
