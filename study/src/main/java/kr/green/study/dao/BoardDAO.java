package kr.green.study.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.study.vo.BoardVO;

public interface BoardDAO {

	ArrayList<BoardVO> selectBoardList();

	BoardVO selectBoard(Integer num);
//매퍼에서 if를 쓰기위해서 1개여도 param을 붙여줌
	void insertBoard(@Param("board")BoardVO board);

}
