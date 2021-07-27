package kr.green.test.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.green.test.service.MemberService;
import kr.green.test.vo.MemberVO;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	MemberService memberService;
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		if(loginCookie != null) {
			MemberVO user = memberService.checkLoginBefore(loginCookie.getValue());
			if(user != null) {
				session.setAttribute("user", user);
			}
		}
		/*Object user = session.getAttribute("user");
		//로그인 안한 상태
		if(user == null) {
			response.sendRedirect(request.getContextPath()+"/signin");
			//원래 가려던 URL로 안 감
			return false;
		}
		//원래 가려던 URL로 감*/
		return true;
	}
}