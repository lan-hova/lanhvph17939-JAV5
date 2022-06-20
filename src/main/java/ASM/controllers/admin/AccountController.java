package ASM.controllers.admin;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ASM.beans.AccountModel;
import ASM.entities.Accounts;
import ASM.repositories.AccountRepository;
import ASM.utils.EncryptUtil;

@Controller
@RequestMapping("/admin/accounts")
public class AccountController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private AccountRepository accountRepo;
	
	@GetMapping("create")
	public String create(@ModelAttribute("account") AccountModel account) 
	{
		request.setAttribute("viewManage", "/views/admin/accounts/create.jsp");
		return "admin/layout/admin";
	}

	@PostMapping("store")
	public String store(@Valid @ModelAttribute("account") Accounts model, BindingResult br) 
	{
		if (br.hasErrors() == true) {
			request.setAttribute("viewManage", "/views/admin/accounts/create.jsp");
			return "admin/layout/admin";
		} else {
//		Accounts acc = new Accounts();
//		acc.setFullname(model.getFullname());
//		acc.setUsername(model.getUsername());
//		acc.setEmail(model.getEmail());
//		acc.setPassword(model.getPassword());
//		acc.setPhoto(model.getPhoto());
//		acc.setAdmin(model.getAdmin());
//		this.accountRepo.save(acc);
			
		
		String password = EncryptUtil.encrypt(this.request.getParameter("password"));
		model.setPassword(password);
		this.accountRepo.save(model);

		return "redirect:/admin/accounts/index";}
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Accounts account) 
	{
		System.out.println(account.getEmail());
		// Account a = this.accountRepo.getById(id);
		this.accountRepo.delete(account);

		return "redirect:/admin/accounts/index";
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") Accounts acc, Model model
			) {
		
		String password = EncryptUtil.encrypt(this.request.getParameter("password"));
		acc.setPassword(password);
		this.accountRepo.save(acc);
		model.addAttribute("acc", acc);
		request.setAttribute("viewManage", "/views/admin/accounts/edit.jsp");
		return "admin/layout/admin";
	}
	
	@PostMapping("update/{id}")
	public String update(@PathVariable("id") Integer a, @ModelAttribute("acc") AccountModel ac) {
		
		Accounts acc = this.accountRepo.getById(a);
		acc.setFullname(ac.getFullname());
		acc.setEmail(ac.getEmail());
		acc.setUsername(ac.getUsername());
		acc.setAdmin(ac.getAdmin());
		acc.setPhoto(ac.getPhoto());
		acc.setActivated(ac.getActivated());
		
		this.accountRepo.save(acc);
		return "redirect:/admin/accounts/index";
	}
	
	@GetMapping("index")
	public String index(
			Model model,
			@RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="size", defaultValue = "6") int size
			) {
		request.setAttribute("viewManage", "/views/admin/accounts/index.jsp");
				Pageable pageable = PageRequest.of(page,size);
				Page<Accounts> p = this.accountRepo.findAll(pageable);
				model.addAttribute("data", p);
				
				
		return "admin/layout/admin";
	}
}