package kr.green.test.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.test.vo.MemberVO;

public interface MemberDAO {
	public String getEmail(@Param("id")String id);

	public void signup(@Param("user")MemberVO user);

	public MemberVO getMember(String string);

}
