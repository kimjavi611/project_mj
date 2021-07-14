package kr.green.spring.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sun.tools.sjavac.Log;

import org.springframework.web.bind.annotation.*;

import kr.green.spring.service.MemberService;
import kr.green.spring.vo.MemberVO;
import lombok.extern.log4j.Log4j;

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
	@GetMapping(value = "/member/mypage")
	public ModelAndView mypageGet(ModelAndView mv) {
		
		mv.setViewName("member/mypage");
		return mv;
	}
	@PostMapping(value = "/member/mypage")
	public ModelAndView mypagePost(ModelAndView mv, MemberVO user, HttpServletRequest r) {
		//user : 화면에서 보낸 회원정보, 정상적이라면 바로 수정해도 되지만 개발자 도구를 이용하여 잘못된 정보를 보낼 수 있기 때문에 바로 수정하면 안됨
		//sUser : 현재 로그인 된 회원 
		//uUser : 업데이트 된 회원 정보로 user의 아이디와 sUser의 아이디가 일치하지 않으면 null, 일치하면 업데이트된 회원 정보
		MemberVO sUser = memberService.getMember(r);
		//Log.info("member/page" +sUser);
		MemberVO uUser = memberService.updateMember(user,sUser);
		if(uUser != null)
			r.getSession().setAttribute("user", uUser); //업데이트 된 내용을 덮어쓴다 
		mv.setViewName("redirect:/member/mypage");
		return mv;
	}
	@GetMapping(value = "/member/signout")
	public ModelAndView signoutGet(ModelAndView mv, HttpServletRequest r) {
		r.getSession().removeAttribute("user");
		mv.setViewName("redirect:/");
		return mv;
	}
}
