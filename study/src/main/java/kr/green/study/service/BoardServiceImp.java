package kr.green.study.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.study.dao.BoardDAO;
import kr.green.study.vo.BoardVO;
import kr.green.study.vo.MemberVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardServiceImp implements BoardService{
	private BoardDAO boardDao;

	@Override
	public ArrayList<BoardVO> getBoardList() {
		return boardDao.selectBoardList();
	}

	@Override
	public BoardVO getBoard(Integer num) {
		if(num == null)
			return null;
		return boardDao.selectBoard(num);
	}

	@Override
	public void insertBoard(BoardVO board, MultipartFile[] fileList, MemberVO user) {
		if(board == null || user == null)
			return;
		board.setWriter(user.getId());
		//잘못접근하는걸 방지하기 위해서 0 으로 만들어줌 => 답변 관리자만 작성할 수 있는데 일반사용자가 임의로 1로 만드는것을 막아주기 위해서
		board.setGroupOrd(0);
		boardDao.insertBoard(board);
		
		
	}

	@Override
	public void insertReplyBoard(BoardVO board, MemberVO user) {
		if(user == null || board == null)
			return;
		board.setWriter(user.getId());
		BoardVO dbBoard = boardDao.selectBoard(board.getOriNo());
		if(dbBoard == null)
			return;
		board.setTitle(dbBoard.getTitle());
		boardDao.insertBoard(board);
	}
}
