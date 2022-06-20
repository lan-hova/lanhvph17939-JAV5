package ASM.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ASM.beans.AccountModel;
import ASM.beans.LoginModel;
import ASM.entities.Accounts;
import ASM.utils.EncryptUtil;
import ASM.repositories.AccountRepository;


@Controller
public class LoginController {
	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	
	@GetMapping("login")
	public String form(@ModelAttribute("login") AccountModel model) {
		return "login";
	}
		
	@PostMapping("xnlogin")
	public String login(@Valid @ModelAttribute("login") LoginModel model, BindingResult result)  {
		HttpSession session = request.getSession();
		if (result.hasErrors()==true) {
			return "login";
		} else {
		
		Accounts acc = this.accountRepo.findByEmail(model.getEmail().trim());
		boolean check = EncryptUtil.check(model.getPassword(),acc.getPassword());
		if (acc!=null && check == true) {
			// Đăng nhập thành công
			session.setAttribute("login", acc);
			System.out.println("thanh cong");
			return "redirect:/admin/layout/admin";
			
		} else {
			// Đăng nhập thất bại		
			session = request.getSession();
			session.setAttribute("messageLg", "Sai Email hoặc Mật khẩu ! ");
		return "redirect:/login";
		}
	}
}
}