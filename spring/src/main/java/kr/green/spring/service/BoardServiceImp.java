package kr.green.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDAO;
import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVO;

@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	BoardDAO boardDao;

	@Override
	public ArrayList<BoardVO> getBoardList(){
		
		return boardDao.getBoradList();
	}

	

	@Override
	public BoardVO getBoard(Integer num) {
		/*if(num == null) {
			return null;
		}
		return boardDao.getBoard(num);*/
		return num == null? null : boardDao.getBoard(num);
	}



	@Override
	public int updateViews(Integer num) {
		//다오에게 게시글 정보를 가져오라고 요청
		BoardVO board = boardDao.getBoard(num);
		if(board == null) {
			return 0;
		}
		board.setViews(board.getViews()+1); //기존게시글 가져와서 조회수만 1증가
		return boardDao.updateBoard(board);
	}

	@Override
	public void insertBoard(BoardVO board) {
		if(board == null) {
			return;
		}
		boardDao.insertBoard(board); 
	}

	@Override
	public int deleteBoard(Integer num) {
		if(num == null) {
			return 0;
		}
		BoardVO board = boardDao.getBoard(num);
		board.setValid("D"); //속성을 바꿔서 안보이게 하기위해서 
		return boardDao.updateBoard(board);
	}



	@Override
	public int updateBoard(BoardVO board) {
		if(board ==null) {
			return 0;
		}
		BoardVO dbboard = boardDao.getBoard(board.getNum());
		dbboard.setContents(board.getContents());
		dbboard.setTitle(board.getTitle());
		return boardDao.updateBoard(dbboard);
		
	}



	@Override
	public int getTotalCount(Criteria cri) {
		//다오한테 cri정보를 넘겨줌 
		return boardDao.getTotalCount(cri);
	}



	


	




	
}
