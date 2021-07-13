package kr.green.spring.service;

import kr.green.spring.vo.MemberVO;

public interface MemberService {

	MemberVO signin(MemberVO user);

	void signup(MemberVO user);
	

	
}
