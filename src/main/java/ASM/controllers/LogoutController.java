package ASM.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	
	@GetMapping("logout")
	public String logout() {
		session = request.getSession();
		session.removeAttribute("login");
		return "redirect:/home";
	}
}
