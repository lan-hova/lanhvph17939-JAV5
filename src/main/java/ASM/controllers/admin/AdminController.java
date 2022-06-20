package ASM.controllers.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class AdminController {
	@Autowired
	HttpServletRequest request;
	@RequestMapping("/admin/layout/admin")
	public String admin() {
		request.setAttribute("viewManage", "adminMain.jsp");
		return "admin/layout/admin";
	}
}
