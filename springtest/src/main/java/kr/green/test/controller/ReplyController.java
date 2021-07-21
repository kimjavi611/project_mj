package kr.green.test.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.green.test.pagination.Criteria;
import kr.green.test.pagination.PageMaker;
import kr.green.test.service.ReplyService;
import kr.green.test.vo.ReplyVO;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ReplyController {
	
	private ReplyService replyService;
	
	@PostMapping(value="/reply/ins")
		public String replyInsPost(@RequestBody ReplyVO reply) {
			replyService.insertReply(reply);
			return "ok";
	}
	@GetMapping(value="/reply/list/{num}/{page}")
	public HashMap<String, Object> replyListGet(
			@PathVariable("num") Integer num,
			@PathVariable("page") Integer page) {
		Criteria cri = new Criteria();
		cri.setPage(page);
		cri.setPerPageNum(5);
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<ReplyVO> list = replyService.getReplyList(num, cri);
		PageMaker pm = new PageMaker();
		pm.setDisplayPageNum(3);
		pm.setCriteria(cri);
		//댓글 갯수를 가져옴
		int totalCount = replyService.getTotalCount(num);
		pm.setTotalCount(totalCount);
		pm.calcData();
		map.put("pm", pm);
		System.out.println(pm);
		map.put("list", list);
		return map;
}
		
}
