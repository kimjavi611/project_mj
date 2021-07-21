package kr.green.test.service;

import java.util.ArrayList;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.MemberVO;
import kr.green.test.vo.ReplyVO;

public interface ReplyService {

	void insertReply(ReplyVO reply);

	ArrayList<ReplyVO> getReplyList(Integer num,Criteria cri);

	int getTotalCount(Integer num);

	String deleteReply(ReplyVO reply, MemberVO user);

}