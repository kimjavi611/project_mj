package kr.green.spring.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.MemberVO;

public interface MemberDAO {
	public MemberVO getMember(@Param("id")String id);

	public void insertMember(@Param("user")MemberVO user);

	public void updateMember(@Param("user")MemberVO sUser);

	public void keepLogin(@Param("id")String id, @Param("session_id")String session_id, @Param("session_limit")Date session_limit);

	public MemberVO getMemberByCookie(@Param("session_id")String value);
	

	

	

}
