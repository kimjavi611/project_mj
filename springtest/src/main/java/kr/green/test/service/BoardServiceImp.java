package kr.green.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.test.dao.BoardDAO;
import kr.green.test.vo.BoardVO;

@Service
public class BoardServiceImp implements  BoardService{
	@Autowired
	BoardDAO boardDao;

	@Override
	public ArrayList<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		return boardDao.getBoardList();
	}

	@Override
	public BoardVO getBoard(Integer num) {
	//게시글 번호가 없으면 게시글이 없다고 전달 => num가 null인지 확인하여 null이면 null을 반환
		if(num == null) {
		return null;
		}
		//다오에세 게시글 번호를 주면서 게사글을 가져오라고 시킴
		BoardVO board = boardDao.getBoard(num);
		//가져온 게시글을 전달, 이 떄 가져온 게시갈은 없을 수도 있다 
		
		return board;
	}
}
