package kr.green.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

import kr.green.spring.service.MemberService;
import kr.green.spring.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	
	@GetMapping(value = "/signup")
	public ModelAndView signupGet(ModelAndView mv) {
		//MemberVO user = new MemberVO();
		//System.out.println(user.getId().trim().length()); => null이 나옴 
		mv.setViewName("member/signup");
		return mv;
	}
	//매개변수 user를 하면 객체가 생성된 후,화면에서 전달한 name과 일치하는 값들을 setter를 이용하여 값을 재설정 
	//일반적으로 매개변수는 객체를 자동으로 생성하는건 아니다. 스프링 프레임워크에서 매개변수랑 일치하는걸 가져오도록 설정되어진것 
	@PostMapping(value = "/signup")
	public ModelAndView signupPost(ModelAndView mv, MemberVO user) {
		memberService.signup(user);
		mv.setViewName("redirect:/");
		return mv;
	}
	@GetMapping(value = "/signin")
	public ModelAndView signinGet(ModelAndView mv) {
		mv.setViewName("member/signin");
		return mv;
	}
	@PostMapping(value = "/signin")
	public ModelAndView signinPost(ModelAndView mv, MemberVO user) {
		MemberVO dbUser = memberService.signin(user);
		//회원정보 있으면 로그인 성공 없으면 실패
		//회원 정보 있으면 메인 페이지로 이동
		if(dbUser != null) {
			mv.setViewName("redirect:/");
			
		}//회원정보 없으면 로그인 페이지
		else {
			mv.setViewName("redirect:/signin");
		}
		mv.addObject("user", dbUser);
		return mv;
	}
}
