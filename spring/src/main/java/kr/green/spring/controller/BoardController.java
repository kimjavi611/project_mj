package kr.green.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVO;
import lombok.extern.log4j.Log4j;
@Log4j //콘솔에 출력하는것 어떠한 컨트롤러에서 출력했는지 알 수 있음 
@Controller
@RequestMapping(value="/board/*") //URL에 /board가 붙음
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/list")
	public ModelAndView list(ModelAndView mv) {
		ArrayList<BoardVO> list = boardService.getBoardList();
		mv.addObject("list", list);
		mv.setViewName("/board/list");
		return mv;
	}
	@RequestMapping(value = "/detail")
	public ModelAndView detail(ModelAndView mv, Integer num) {
		boardService.updateViews(num);
		//log.info(num);
		//게시글 번호를 가져와서 화면에 보여줌 
		BoardVO board = boardService.getBoard(num);
		mv.addObject("board", board);
		mv.setViewName("/board/detail");
		return mv;
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.GET)
	public ModelAndView register(ModelAndView mv) {
		
		mv.setViewName("/board/register");
		return mv;
	}
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public ModelAndView registerPost(ModelAndView mv, BoardVO board) {
		boardService.insertBoard(board);
		mv.setViewName("redirect:/board/list"); //동작 처리후에 보낼곳 
		return mv;
	}
	@RequestMapping(value = "/modify", method=RequestMethod.GET)
	public ModelAndView modify(ModelAndView mv, Integer num) {
		//수정할 게시글을 가져와서 화면에 보여줌 
		BoardVO board = boardService.getBoard(num); //detail만들때 정보 불러오는거 만들어놔서 이용
		mv.addObject("board", board); 
		mv.setViewName("/board/modify");
		return mv;
	}
	@RequestMapping(value = "/modify", method=RequestMethod.POST)
	public ModelAndView modifyPost(ModelAndView mv, BoardVO board) {
		boardService.getModify(board);
		mv.setViewName("/board/modify");
		return mv;
	}
}
