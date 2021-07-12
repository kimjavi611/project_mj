package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.MemberVO;

public interface MemberDAO {
	public String getEmail(@Param("id")String id);

	public void signup(@Param("user")MemberVO user);

	public MemberVO getMember(@Param("id")String id);

	public int updateMember(@Param("user")MemberVO dbUser);

	

}
