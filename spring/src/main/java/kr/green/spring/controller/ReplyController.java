package kr.green.spring.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.service.ReplyService;
import kr.green.spring.vo.ReplyVO;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ReplyController {
	
	private ReplyService replyService;
	
	@PostMapping("/reply/ins")
	public String replyInsGet(@RequestBody ReplyVO rvo) {
		//System.out.println(rvo);
		return replyService.insertReply(rvo) == 0 ? "FAIL" : "OK";
	}
	
	@GetMapping("/reply/list/{rp_bd_num}/{page}")
	public Map<String, Object> replyListGet(@PathVariable("rp_bd_num") int rp_bd_num,
			@PathVariable("page")int page){
		//System.out.println(page);
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		Criteria cri = new Criteria(page, 5);
		int totalCount = replyService.getTotalCount(rp_bd_num);
		PageMaker pm = new PageMaker(totalCount, 3, cri);
		System.out.println(pm);
		
		ArrayList<ReplyVO> list = replyService.getReplyList(rp_bd_num, cri);
		//System.out.println(list);
		map.put("replyList", list);
		map.put("pm",pm);
		//System.out.println(list);
		return map;
	}
	@PostMapping("/reply/mod")
	public String replyModPost(@RequestBody ReplyVO reply) {
		//System.out.println(reply);
		return replyService.updateReply(reply);
	}
	@PostMapping("/reply/del")
	public String replyDelPost(@RequestBody ReplyVO reply) {
		//return reply.toString();
		return replyService.deleteReply(reply);
	}
}
