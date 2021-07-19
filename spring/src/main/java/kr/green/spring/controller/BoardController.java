package kr.green.spring.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.service.BoardService;
import kr.green.spring.service.MemberService;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;
import kr.green.spring.vo.MemberVO;
import lombok.extern.log4j.Log4j;
@Log4j //콘솔에 출력하는것 어떠한 컨트롤러에서 출력했는지 알 수 있음 
@Controller
@RequestMapping(value="/board/*") //URL에 /board가 붙음
public class BoardController {
	@Autowired
	BoardService boardService;
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/list")
	public ModelAndView list(ModelAndView mv, String msg, Criteria cri) {
		cri.setPerPageNum(2);
		
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		//현재 페이지 정보(검색타입 검색어)에 대한 총 게시글 수를 가져와야함
		int totalCount = boardService.getTotalCount(cri);
		PageMaker pm = new PageMaker(totalCount, 2, cri);
		mv.addObject("pm", pm); //현재 페이지 정보를 전달 
		mv.addObject("msg", msg);
		mv.addObject("list", list);
		mv.setViewName("/template/board/list");
		return mv;
	}
	@RequestMapping(value = "/detail")
	public ModelAndView detail(ModelAndView mv, Integer num, String msg) {
		boardService.updateViews(num);
		//log.info(num);
		//게시글 번호를 가져와서 화면에 보여줌 
		BoardVO board = boardService.getBoard(num);
		mv.addObject("msg", msg);
		mv.addObject("board", board);
		
		ArrayList<FileVO> fileList = boardService.getFileList(num);
		mv.addObject("fileList", fileList);
		mv.setViewName("/template/board/detail");
		return mv;
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.GET)
	public ModelAndView register(ModelAndView mv) {
		mv.setViewName("/board/register");
		return mv;
	}
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public ModelAndView registerPost(ModelAndView mv, BoardVO board, HttpServletRequest r, 
			MultipartFile [] files) {
		MemberVO user = memberService.getMember(r);
		boardService.insertBoard(board,user, files);
		mv.setViewName("redirect:/board/list"); //동작 처리후에 보낼곳 
		return mv;
	}
	@RequestMapping(value = "/modify", method=RequestMethod.GET)
	public ModelAndView modify(ModelAndView mv, Integer num) {//번호 가져오고 출력 찍어봐야됨잉
		//수정할 게시글을 가져와서 화면에 보여줌 
		BoardVO board = boardService.getBoard(num); //detail만들때 정보 불러오는거 만들어놔서 이용
		mv.addObject("board", board); 
		//첨부파일 가져옴
		ArrayList<FileVO> fileList = boardService.getFileList(num);
		//화면에 첨부파일 전송
		mv.addObject("fileList",fileList);
		mv.setViewName("/template/board/modify");
		return mv;
	}
	@RequestMapping(value = "/modify", method=RequestMethod.POST)
	public ModelAndView modifyPost(ModelAndView mv, BoardVO board,HttpServletRequest r, MultipartFile[] files, Integer[] filenums) {//번호 가져오고 출력 찍어봐야됨잉
		MemberVO user = memberService.getMember(r);
		//수정할 게시글 정보를 가져옴
		int res = boardService.updateBoard(board, user, files, filenums);
		String msg="" ;
		mv.setViewName("redirect:/board/detail");
		if(res==1)
			msg = board.getNum()+ "번 게시글이 수정되었습니다.";
		else if(res==0)	
		 msg ="없는 게시글입니다.";
		else if(res==-1)
			msg = "잘못된 접근입니다.";
		mv.setViewName("redirect:/board/list");
		mv.addObject("num", board.getNum());
		mv.addObject("msg", msg);
		return mv;
		
	}
	@RequestMapping(value = "/delete", method=RequestMethod.POST)
	public ModelAndView deletePost(ModelAndView mv, Integer num, HttpServletRequest r) { //화면에서 서버로 보내주는건 매개변수로!
		MemberVO user = memberService.getMember(r);
		int res = boardService.deleteBoard(num, user);
		if(res == 1) {
			mv.addObject("msg", num + "번 게시물을 삭제 했습니다"); //mv.addObject는 setViewName으로 보내는것 
		}else if(res== 0){
			mv.addObject("msg", "게시글이 없거나 이미 삭제되었습니다.");
		}else if(res==-1) {
			mv.addObject("msg", "잘못된 접근입니다.");
		}
		mv.setViewName("redirect:/board/list");
		
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
		return boardService.downloadFile(fileName);
	  
	}
	
}
