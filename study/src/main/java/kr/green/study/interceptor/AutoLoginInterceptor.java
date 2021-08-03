package kr.green.study.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.green.study.service.MemberService;
import kr.green.study.vo.MemberVO;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	MemberService memberService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		//user는 로그인인터셉터의 session.setAttribute("user", user);앞 user랑 맞춘다
		MemberVO user = (MemberVO)session.getAttribute("user");
		/*Object obj = session.getAttribute("user");
		MemberVO user = null;
		if(obj instanceof MemberVO)
			user = (MemberVO) obj;
		*/
		//세션에 회원 정보가 있으면 자동 로그인 기능을 활용할 필요가 없고, 없으면 자동 로그인을 해야하는지 확인 
		if(user == null) {
			//loginCookie 정보를 가져와서 있으면 자동 로그인을 시도하고 없으면 안한다
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			//자동 로그인 쿠키 정보가 있으면 자동 로그인을 해야함 
			if(loginCookie != null) {
				user = memberService.getMemberByCookie(loginCookie.getValue());
				if(user != null)
					session.setAttribute("user", user);
			}
		}
		//컨트롤러로 가기전에 동작, 원래 가려던 컨트롤러로 가게 하는게  return true; 다른 URL로 이동시킬땐 return false 보통 sendRedirect와 함께 쓰임
		return true;
	}
}
