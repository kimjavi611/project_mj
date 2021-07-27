package kr.green.spring.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import kr.green.spring.vo.MemberVO;

public interface MemberService {

	MemberVO signin(MemberVO user);

	void signup(MemberVO user);

	MemberVO getMember(HttpServletRequest r);

	MemberVO updateMember(MemberVO user, MemberVO sUser);

	boolean idCheck(String id);

	void keepLogin(String id, String session_id, Date session_limit);

	MemberVO getMemberByCookie(String value);

	String findPw(String id);
	

	
}
