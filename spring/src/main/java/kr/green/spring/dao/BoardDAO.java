package kr.green.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;

public interface BoardDAO {

	ArrayList<BoardVO> getBoradList(@Param("cri")Criteria cri);


	BoardVO getBoard(@Param("num")Integer num);


	int updateBoard(@Param("board")BoardVO board);


	void insertBoard(@Param("board")BoardVO board);


	BoardVO getModify(@Param("num")Integer num);


	int getTotalCount(@Param("cri")Criteria cri);


	void insertFile(@Param("file")FileVO fvo);


	ArrayList<FileVO> getFileList(@Param("num")Integer num);


	

	
}
