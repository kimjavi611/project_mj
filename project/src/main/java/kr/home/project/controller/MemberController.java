package kr.home.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.home.project.service.MemberService;

@Controller
public class MemberController {
	@Autowired	
	MemberService memberService;
	
	    @RequestMapping(value="/")
	    public ModelAndView main(ModelAndView mv) throws Exception{
	        mv.setViewName("/home");
	        mv.addObject("setHeader", "타일즈테스트");
	        System.out.println(memberService.getEmail("kkk123"));
	        return mv;
	    }

}
