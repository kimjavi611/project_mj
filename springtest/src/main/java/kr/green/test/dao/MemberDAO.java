package kr.green.test.dao;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

import kr.green.test.vo.MemberVO;

public interface MemberDAO {
	public String getEmail(@Param("id")String id);

	public void signup(@Param("user")MemberVO user);

	public MemberVO getMember(@Param("id")String id);

	public int updateMember(@Param("user")MemberVO dbUser);

	public ArrayList<MemberVO> getMemberByEmail(@Param("email")String email);

	public void keeplogin(@Param("id")String id, @Param("session_id")String session_id, @Param("session_limit")Date session_limit);

	public MemberVO getMemberBySessionId(@Param("session_id")String session_id);

	

}
