package kr.green.spring.service;

import java.util.ArrayList;

import kr.green.spring.vo.BoardVO;

public interface BoardService {

	ArrayList<BoardVO> getBoardList();

	BoardVO getBoard(Integer num);

	int updateViews(Integer num);


	void insertBoard(BoardVO board);

	BoardVO getModify(BoardVO board);

}
