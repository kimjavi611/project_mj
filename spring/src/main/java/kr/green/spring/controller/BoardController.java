package kr.green.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
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
	public ModelAndView list(ModelAndView mv, String msg, Criteria cri) {
		log.info(cri);
		//한 페이지에 보여지는 개시글 갯수
		cri.setPerPageNum(3);
		PageMaker pm = new PageMaker();
		//현재 페이지정보
		pm.setCriteria(cri);
		//한페이지에서 보여지는 페이지네이션 갯수
		pm.setDisplayPageNum(5);
		//총 게시글 갯수만큼 페이지네이션 생성 
		//총 게시글 갯수
		int totalCount = boardService.getTotalCount(cri);
		pm.setTotalCount(totalCount);
		pm.calcData();
		mv.addObject("pm", pm);
		ArrayList<BoardVO> list = boardService.getBoardList();
		mv.addObject("msg", msg);
		mv.addObject("list", list);
		mv.setViewName("/board/list");
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
	public ModelAndView modify(ModelAndView mv, Integer num) {//번호 가져오고 출력 찍어봐야됨잉
		//수정할 게시글을 가져와서 화면에 보여줌 
		BoardVO board = boardService.getBoard(num); //detail만들때 정보 불러오는거 만들어놔서 이용
		mv.addObject("board", board); 
		mv.setViewName("/board/modify");
		return mv;
	}
	@RequestMapping(value = "/modify", method=RequestMethod.POST)
	public ModelAndView modifyPost(ModelAndView mv, BoardVO board) {//번호 가져오고 출력 찍어봐야됨잉
		//수정할 게시글 정보를 가져옴
		log.info("/board/modify:POST: "+board);
		int res = boardService.updateBoard(board);
		String msg = res != 0 ? board.getNum()+ "번 게시글이 수정되었습니다." : "없는 게시글입니다.";
		mv.addObject("num", board.getNum());
		mv.addObject("msg", msg);
		mv.setViewName("redirect:/board/detail");
		return mv;
	}
	@RequestMapping(value = "/delete", method=RequestMethod.POST)
	public ModelAndView deletePost(ModelAndView mv, Integer num) { //화면에서 서버로 보내주는건 매개변수로!
		int res = boardService.deleteBoard(num);
		if(res != 0) {
			mv.addObject("msg", num + "번 게시물을 삭제 했습니다"); //mv.addObject는 setViewName으로 보내는것 
		}else {
			mv.addObject("msg", "게시글이 없거나 이미 삭제되었습니다.");
		}
		mv.setViewName("redirect:/board/list");
		return mv;
	}
}
