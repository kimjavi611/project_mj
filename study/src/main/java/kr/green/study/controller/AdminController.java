package kr.green.study.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.study.pagination.Criteria;
import kr.green.study.pagination.PageMaker;
import kr.green.study.service.MemberService;
import kr.green.study.vo.MemberVO;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {
	
	MemberService memberService;
	
	@GetMapping("/user/list")
	public ModelAndView userListGet(ModelAndView mv, HttpServletRequest request, Criteria cri) {
		MemberVO user = memberService.getMemberByRequest(request);
		cri.setPerPageNum(2);
		ArrayList<MemberVO> list = memberService.getMemberList(user, cri);
		int totalCount = memberService.getTotalCount(user);
		//토탈카운트, 보여줄 페이지수, 현재페이지 정보 필요
		// 토탈카운트를 모름 => 알아봐야함 
		PageMaker pm = new PageMaker(totalCount, 1, cri);
		System.out.println(pm);
		mv.addObject("list", list);
		mv.addObject("pm", pm);
		mv.setViewName("/template/admin/user/list");
		return mv;
	}
	@ResponseBody
	@PostMapping("/user/mod")
	public String userModPost(@RequestBody MemberVO user, HttpServletRequest request) {
		MemberVO loginUser = memberService.getMemberByRequest(request);
		
		return memberService.updateAuthority(user, loginUser) ? "OK" : "FAIL";
	}
}
