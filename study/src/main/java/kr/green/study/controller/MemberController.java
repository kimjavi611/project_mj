package kr.green.study.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.study.service.MemberService;
import kr.green.study.vo.MemberVO;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MemberController {
	
	MemberService memberService;
	
	@GetMapping("/member/signup")
	public ModelAndView memberSignupGet(ModelAndView mv) {
		mv.addObject("title", "회원가입");
		mv.setViewName("/template/member/signup");
		return mv;
	}

	@PostMapping("/member/signup")
	public ModelAndView memberSignupPost(ModelAndView mv, MemberVO user) {
		boolean isSignup = memberService.signup(user);
		mv.setViewName("redirect:/");
		return mv;
	}
	@GetMapping("/member/signin")
	public ModelAndView memberSigninGet(ModelAndView mv) {
		
		mv.addObject("title", "로그인");
		mv.setViewName("/template/member/signin");
		return mv;
	}
	
	@PostMapping("/member/signin")
	public ModelAndView memberSigninPost(ModelAndView mv, MemberVO user) {
		//System.out.println(user);
		MemberVO loginUser = memberService.signin(user);
		//System.out.println(loginUser);
		if(loginUser !=null)
			mv.setViewName("redirect:/");
		else
			mv.setViewName("redirect:/member/signin");
		mv.addObject("user", loginUser);
		return mv;
	}
	@ResponseBody
	@PostMapping("/id/check")
	public String idCheck(String id) {
		return memberService.getMember(id) != null ? "FAIL" : "OK";
	}
	@GetMapping("/member/signout")
	public ModelAndView memberSignout(ModelAndView mv, HttpServletRequest request,
			HttpServletResponse reponse) {
		memberService.signout(request,reponse);
		mv.setViewName("redirect:/");
		return mv;
	}
	
}
