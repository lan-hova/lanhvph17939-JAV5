package ASM.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ASM.entities.Products;
import ASM.repositories.ProductRepository;

@Controller
public class HomeController {
	
	@Autowired
	private ProductRepository productRepo;
	
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String home
	(
			Model model,
			@RequestParam(name = "page", defaultValue = "0") Integer page
	) {
		Pageable pageable = PageRequest.of(page, 6);
		Page<Products> lstProduct = this.productRepo.findAll(pageable);
		model.addAttribute("lstproduct", lstProduct);
		model.addAttribute("viewhome", "/views/user/load_img/loadAll.jsp");
		return "user/home";
	}
}
