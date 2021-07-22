package kr.green.spring.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;
import kr.green.spring.vo.MemberVO;
import kr.green.spring.vo.RecommendVO;

public interface BoardService {

	ArrayList<BoardVO> getBoardList(Criteria cri);

	BoardVO getBoard(Integer num);

	int updateViews(Integer num);


	void insertBoard(BoardVO board, MemberVO user, MultipartFile [] files);

	int deleteBoard(Integer num,MemberVO user);

	int updateBoard(BoardVO board,MemberVO user,MultipartFile[] files, Integer[] filenums);

	int getTotalCount(Criteria cri);

	ArrayList<FileVO> getFileList(Integer num);

	ResponseEntity<byte[]> downloadFile(String fileName)throws IOException;

	String recommend(int board, int state, MemberVO user);

	RecommendVO getRecommend(Integer num, MemberVO user);

}
