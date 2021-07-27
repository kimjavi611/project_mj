package kr.green.spring.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.spring.service.MemberService;
import kr.green.spring.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	MemberService memberService;
	
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
	    ModelMap modelMap = modelAndView.getModelMap();
	    MemberVO user = (MemberVO)modelMap.get("user");
	    //System.out.println(user);
	    if(user != null) {
	        HttpSession session = request.getSession();
	        session.setAttribute("user", user);
	        if(user.getUseCookie() != null) {
	        	Cookie loginCookie = new Cookie("loginCookie", session.getId());
	        	int amount = 60*60*24*7;
	        	loginCookie.setPath("/");
	        	loginCookie.setMaxAge(60*60*24*7);
	        	response.addCookie(loginCookie);
	        	memberService.keepLogin(user.getId(),session.getId(),new Date(System.currentTimeMillis()+amount*1000));
	        	
	        }
	    }
	}
}
