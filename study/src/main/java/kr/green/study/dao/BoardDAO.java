package kr.green.study.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.study.vo.BoardVO;

public interface BoardDAO {

	ArrayList<BoardVO> selectBoardList();

	BoardVO selectBoard(Integer num);
//留ㅽ띁�뿉�꽌 if瑜� �벐湲곗쐞�빐�꽌 1媛쒖뿬�룄 param�쓣 遺숈뿬以�
	void insertBoard(@Param("board")BoardVO board);

	void updateBoard(BoardVO dbBoard);

	void deleteBoard(Integer num);

	void deleteReplyBoard(Integer num);

}
