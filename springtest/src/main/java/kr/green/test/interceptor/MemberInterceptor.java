package kr.green.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");
		//로그인 안한 상태
		if(user == null) {
			response.sendRedirect(request.getContextPath()+"/signin");
			//원래 가려던 URL로 안 감
			return false;
		}
		//원래 가려던 URL로 감
		return true;
	}
}