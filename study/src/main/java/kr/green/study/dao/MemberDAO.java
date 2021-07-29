package kr.green.study.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import kr.green.study.vo.MemberVO;

public interface MemberDAO {

	void insertMember(MemberVO user);

	MemberVO selectUser(String id);

	void keepLogin(@Param("id")String id, @Param("session_id")String session_id, @Param("session_limit")Date session_limit);

	MemberVO selectUserBySession(String session_id);

	

}
