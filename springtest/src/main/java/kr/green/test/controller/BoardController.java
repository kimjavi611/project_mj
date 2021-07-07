package kr.green.test.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.service.BoardService;
import kr.green.test.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/board/list")
	public ModelAndView boardList(ModelAndView mv) {
		//서비스에게 모든 게시글을 가져오라고 시킴
		ArrayList<BoardVO> list = boardService.getBoardList();
		//화면에 모든 게시글을 전송
		mv.addObject("list",list);
		if(list != null) {
			for(BoardVO tmp : list) {
				System.out.println(tmp); 
			}
		}
		mv.setViewName("board/list");
		return mv;
	}
	@RequestMapping(value="/board/detail")
	public ModelAndView boardDetail(ModelAndView mv, Integer num) { //int는 url이 잘못됐을때(NULL)이 됐을 때 에러가 뜬다. null값을 가질 수 없기 때문
		//서비스에게 번호를 주면서 게시글을 가져오라고 시킴 
		//게시글 정보 가져오는 작업을 먼저 해야함
		BoardVO board = boardService.getBoard(num);
		//가져온 게시글을 화면에 전달, 화면으로 보낼 이름은 board로
		mv.addObject("board", board);
		mv.setViewName("board/detail");
		return mv;
	}
	@RequestMapping(value="/board/register", method=RequestMethod.GET) //전송방식이 get일때 주소가 너무 길어질 수 있음 =>실제 처리는 post이용
	public ModelAndView boardRegisterGet(ModelAndView mv) { 
		
		mv.setViewName("board/register");
		return mv;
	}
	//화면에서 보내주는 제목, 작성자, 내용을 받아서 콘솔에 출력
	@RequestMapping(value="/board/register", method=RequestMethod.POST) //jsp에서 action="post"한 후 Mapping추가 해줌
	public ModelAndView boardRegisterPost(ModelAndView mv,BoardVO board ) { 
		//서비스에게 게시글 정보(제목,작성자, 내용)을 주면서 게시글을 등록하라고 시킴
		boardService.insertBoard(board);
		mv.setViewName("redirect:/board/list");//등록후에 다시 메인으로 
		return mv;
	}
	
}
