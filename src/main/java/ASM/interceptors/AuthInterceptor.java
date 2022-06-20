package ASM.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import ASM.entities.Accounts;

@Component
public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Accounts accounts = (Accounts) request.getSession().getAttribute("login");
		if (accounts == null) {
			response.sendRedirect("/SOF3021_ASM/login");
			return false;
		} else if (accounts.getAdmin() != 1) {
			response.sendRedirect("/SOF3021_ASM/home");
			System.out.println("aaa");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
	
}
