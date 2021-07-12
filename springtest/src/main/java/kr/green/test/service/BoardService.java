package kr.green.test.service;

import java.util.ArrayList;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.BoardVO;
import kr.green.test.vo.MemberVO;

public interface BoardService {

	ArrayList<BoardVO> getBoardList(Criteria cri);

	BoardVO getBoard(Integer num);

	void insertBoard(BoardVO board);

	int updateViews(Integer num);

	int updateBoard(BoardVO board);

	int deleteBoard(Integer num, MemberVO user);

	int getTotalCount(Criteria cri);

}
