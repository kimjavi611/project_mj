package kr.green.test.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.test.dao.BoardDAO;
import kr.green.test.pagination.Criteria;
import kr.green.test.utils.UploadFileUtils;
import kr.green.test.vo.BoardVO;
import kr.green.test.vo.FileVO;
import kr.green.test.vo.MemberVO;
import kr.green.test.vo.RecommendVO;

@Service
public class BoardServiceImp implements  BoardService{
	@Autowired
	BoardDAO boardDao;
	private String uploadPath ="D:\\JAVA_KMJ\\uploadfiles";

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		// TODO Auto-generated method stub
		return boardDao.getBoardList(cri);
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

	@Override
	public void insertBoard(BoardVO board, MultipartFile [] file) {
		//다오에게 게시글 정보를 주면서 게시글 등록하라고 시킴
		boardDao.insertBoard(board);
		//System.out.println("게시글 번호" + board.getNum()); 정보 잘 불러오나 확인
		if(file == null)
			return;
		for(MultipartFile tmp : file)
			insertFileVO(tmp, board.getNum());
		
	}

	@Override
	public int updateViews(Integer num) {
		//다오에게 게시글 번호를 주고 게시글을 가져오라고 시킴
		BoardVO board = boardDao.getBoard(num);
		//가져온 게시글이 있으면 가져온 게시글의 조회수를 1증가 시킴
		if(board != null){
		board.setViews(board.getViews()+1);
		//다오에게 게시글을 주면서 게시글을 수정하라고 요청
		return boardDao.updateBoard(board);
		}
		return 0;
	}

	@Override
	public int updateBoard(BoardVO board, MultipartFile []file,Integer[]fileNum) {
		if(board == null || board.getNum()<= 0) {
			return 0;
		}
		if(board.getValid()==null) {
			board.setValid("I");
		}
		//fileList : 1,2,3 , fileNum : 1,3 
		//파일리스트에는 있는데 파일이 없다면 지워진것 => fileList에 있는 파일을 하나씩 꺼내서 fileNum에 있는지 비교함
		//배열에 있는 값들을 리스트에 저장 (배열 => 리스트)
		ArrayList<Integer> nums = new ArrayList<Integer>();
		if(fileNum != null) {
			for(Integer tmp : fileNum) {
				nums.add(tmp);
			}
		}	
		//기존에서 빠진게 있나 확인해야해서 파일 불러 와야함
		//기존에 첨부되었던 파일중 삭제된 파일을 제거 
		ArrayList<FileVO> fileList = boardDao.getFileVOList(board.getNum());
		if(fileList != null) {
			for(FileVO tmp : fileList) {
				if(!nums.contains((Integer)tmp.getNum())) {
					deleteFileVO(tmp);
				}
			}
		}	
		//새로 추가된 파일을 추가
		if(fileList != null) {
			for(MultipartFile tmp : file) {
				insertFileVO(tmp, board.getNum());
			}
		}
		/*
		FileVO fileVo = boardDao.getFileVO(board.getNum());
		//첨부파일이 추가되는 경우 
		if(fileVo == null && (file != null && file.getOriginalFilename().length()!=0)) {
			insertFileVO(file,board.getNum());
		}
		//첨부파일이 삭제되는 경우
		else if(fileVo != null && (file != null && file.getOriginalFilename().length()==0)) {
			//업로드 되었던 파일을 삭제 
			deleteFileVO(fileVo);
		}
		//첨부파일이 수정되는 경우
		else if(fileVo != null && (file== null || file.getOriginalFilename().length()==0)) {
			//업로드 되었던 파일을 삭제 
			File ftmp = new File(uploadPath+fileVo.getName());
			deleteFileVO(fileVo);
			insertFileVO(file,board.getNum());
		}*/
	
		return boardDao.updateBoard(board);
	}

	@Override
	public int deleteBoard(Integer num, MemberVO user) {
		//다오에게 게시글 번호를 주면서 가져오라고 시킴
		BoardVO board = boardDao.getBoard(num);
		if(board == null || user == null || !board.getWriter().equals(user.getId())) {
			return 0;
		}
		//가져온 게시글의 vaild값을 D로 수정
		board.setValid("D");
		
		//첨부파일 삭제
		//해당 게시글와 일치하는 첨부파일 정보들을 가져옴
		//반복문으로 하나씩 삭제 처리
		ArrayList<FileVO> fileList = boardDao.getFileVOList(num);
		if(fileList != null && fileList.size() != 0) {
			for(FileVO tmp : fileList) {
				deleteFileVO(tmp);
			}
		}
		
		//다오에게 게시글 정보를 주면서 수정하라고 시킨 후 정수값을 리턴
		return boardDao.updateBoard(board);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return boardDao.getTotalCount(cri);
	}

	@Override
	public ArrayList<FileVO> getFileVOList(Integer num) {
		if(num == null)
			return null;
		
		return boardDao.getFileVOList(num);
	}

	@Override
	public ResponseEntity<byte[]> downloadFile(String fileName) throws IOException {
		ResponseEntity<byte[]> entity = null;
		 InputStream in = null;
		    try{
		        String FormatName = fileName.substring(fileName.lastIndexOf(".")+1);
		        HttpHeaders headers = new HttpHeaders();
		        //FileInputStream : 해당 파일을 읽어옴
		        in = new FileInputStream(uploadPath+fileName);
		        fileName = fileName.substring(fileName.indexOf("_")+1);
		        //헤더에 파일 정보를 담아줌 
		        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		        headers.add("Content-Disposition",  "attachment; filename=\"" 
					+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
		        //새 객체를 만들어서 정보를 저장해줌 
		        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
		    }catch(Exception e) {
		        e.printStackTrace();
		        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		    }finally {
		        in.close();
		    }
		return entity;
	}
	//파일을 서버에 업로드 한 후 DB에 추가하는 메소드
	private void insertFileVO(MultipartFile file, int num) {
		if(file != null && file.getOriginalFilename().length() != 0) {
			try {
				String filename = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
				FileVO fileVo = new FileVO(num, filename, file.getOriginalFilename());
				boardDao.insertFile(fileVo);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("첨부파일 업로드 중 예외 발생");
			}
		}
	}
	//서버에 업로드된 파일을 삭제 후, DB에 삭제 처리하는 메소드
	private void deleteFileVO(FileVO file) {
		File ftmp = new File(uploadPath+file.getName());
		if(ftmp.exists()) {
			ftmp.delete();
		}
		
		boardDao.deleteFileVO(file.getNum());
	}

	@Override
	public int updateRecommend(MemberVO user, int board ,int state) {
		if(user == null)
			return -1;
		//게시글 번호와 유저 id를 이용하여 추천/비추천 한 적이 있는지 확인
		RecommendVO rvo = boardDao.getRecommend(user.getId(),board);
		//없으면 추가하고 1을 리턴
		if(rvo == null) {
			boardDao.insertRecommend(user.getId(), board, state);
			return 1;
		//있으면 
		}else {
			// 기존 state 정보와 누른 버튼 정보를 비교하여 같으면 state을 0으로 수정하고 0을 리턴 
			//(추천 누르고 추천, 비추 누르고 비추)
			if(state == rvo.getState()) {
				rvo.setState(0);
				boardDao.updateRecommend(rvo);
				return 0;
			}
			//다르면 누른 정보로 수정하고 1을 리턴(추천 누르고 비추, 비추 누르고 추천)
			else {
				rvo.setState(state);
				boardDao.updateRecommend(rvo);
				return 1;
			}
		}
		
	}

	@Override
	public RecommendVO getRecommend(MemberVO user, Integer num) {
		if(user == null || num == null)
			return null;
		return boardDao.getRecommend(user.getId(), num);
	}
}
