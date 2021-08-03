package kr.green.study.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.study.pagination.Criteria;
import kr.green.study.pagination.PageMaker;
import kr.green.study.service.BoardService;
import kr.green.study.service.MemberService;
import kr.green.study.vo.BoardVO;
import kr.green.study.vo.FileVO;
import kr.green.study.vo.MemberVO;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/board/image")
public class BoardController {
	private BoardService boardService;
	private MemberService memberService;
	
	@GetMapping("/list")
	public ModelAndView listGet(ModelAndView mv, Criteria cri) {
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		int totalCount = boardService.getTotalCount(cri);
		PageMaker pm = new PageMaker(totalCount, 10, cri);
		mv.addObject("pm", pm);
		//System.out.println(list);
		mv.addObject("list", list);
		mv.setViewName("/template/board/image/list");
		return mv;
	}
	@GetMapping("/detail")
	public ModelAndView detailGet(ModelAndView mv, Integer num) {
		
		mv.setViewName("/template/board/image/list");
		return mv;
	}
	@PostMapping("/detail")
	public ModelAndView detailPost(ModelAndView mv, BoardVO tmpBoard) {
		if(boardService.checkBoardPw(tmpBoard)) {
			boardService.updateViews(tmpBoard.getNum());
			//System.out.println(num);
			BoardVO board = boardService.getBoard(tmpBoard.getNum());
			
			ArrayList<FileVO> fList = boardService.getFileList(tmpBoard.getNum());
			mv.addObject("fList", fList);
			mv.addObject("board", board);
			mv.setViewName("/template/board/image/detail");
		}else {
			mv.setViewName("redirect:/board/image/list");
		}
		return mv;
	}
	@GetMapping("/register")
	public ModelAndView registerGet(ModelAndView mv) {
		mv.setViewName("/template/board/image/register");
		return mv;
	}
	@PostMapping("/register")
	public ModelAndView registerPost(ModelAndView mv, BoardVO board, MultipartFile [] fileList,
			HttpServletRequest request) throws Exception {
		//System.out.println(board);
		//�뙆�씪 �씠由� �젣��濡� 李랁엳�뒗吏� 諛섎났臾몄쑝濡� �솗�씤 
		/*for(MultipartFile tmp : fileList) {
			if(tmp != null)
				System.out.println(tmp.getOriginalFilename());
		}*/
		MemberVO user = memberService.getMemberByRequest(request);
		board.setType("NORMAL");
		boardService.insertBoard(board, fileList, user);
		mv.setViewName("redirect:/board/image/list");
		return mv;
	}
	@GetMapping("/reply/image/register")
	public ModelAndView replyRegisterGet(ModelAndView mv, Integer oriNo) {
		mv.addObject("oriNo", oriNo);
		mv.setViewName("/template/board/image/replyregister");
		return mv;
	}
	@PostMapping("/reply/image/register")
	public ModelAndView replyRegisterPost(ModelAndView mv, BoardVO board,
			HttpServletRequest request, MultipartFile[] fileList) throws Exception {
		MemberVO user = memberService.getMemberByRequest(request);
		board.setType("NORMAL");
		boardService.insertReplyBoard(board,user);
		mv.setViewName("redirect:/board/image/list");
		return mv;
	}
	@GetMapping("/modify")
	public ModelAndView boardModifyGet(ModelAndView mv, Integer num) {
		BoardVO board = boardService.getBoard(num);
		ArrayList<FileVO> fList = boardService.getFileList(num);
		mv.addObject("board", board); 
		mv.addObject("fList",fList);
		mv.setViewName("/template/board/image/modify");
		return mv;
	}
	@PostMapping("/modify")
	public ModelAndView boardModifyPost(ModelAndView mv, BoardVO board,
			HttpServletRequest request, MultipartFile[] fileList, Integer [] fileNumList)  throws Exception {
		//작성내용이 컨트롤러로 넘어오는지 확인 
		//System.out.println(board);
		MemberVO user = memberService.getMemberByRequest(request);
		boardService.updateBoard(board,user,fileList, fileNumList);
		mv.addObject("num", board.getNum());
		mv.setViewName("redirect:/board/image/detail");
		return mv;
	}
	@GetMapping("/delete")
	public ModelAndView deleteGet(ModelAndView mv, Integer num, HttpServletRequest request) {
		MemberVO user = memberService.getMemberByRequest(request);
		boardService.deleteBoard(num, user);
		mv.setViewName("/template/board/image/list");
		return mv;
	}
	@ResponseBody
	@GetMapping("/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
	    return boardService.downloadFile(fileName);
	}
	
}
