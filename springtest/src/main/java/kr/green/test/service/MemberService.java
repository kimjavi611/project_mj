package kr.green.test.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.green.test.vo.MemberVO;

public interface MemberService {
	

	public MemberVO signin(MemberVO user);

	public boolean signup(MemberVO user);

	public MemberVO getMember(String id);

	public MemberVO updateMember(MemberVO user);

	public MemberVO getMember(HttpServletRequest request);

	public ArrayList<MemberVO> getMemberByEmail(String email);

}
