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

import ASM.beans.CategoryModel;
import ASM.entities.Categories;
import ASM.repositories.CategoryRepository;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	private CategoryRepository cateRepo;
	
	@GetMapping("create")
	public String create(@ModelAttribute("cate") CategoryModel cate) {
		request.setAttribute("viewManage", "/views/admin/categories/create.jsp");
		return "admin/layout/admin";
	}
	
	@PostMapping("store")
	public String store(@Valid @ModelAttribute("cate") CategoryModel model,
			BindingResult br ) {
		if (br.hasErrors() == true) {
			request.setAttribute("viewManage", "/views/admin/categories/create.jsp");
			return "admin/layout/admin";
		} else {
		Categories cate = new Categories();
		cate.setName(model.getName());
		
		this.cateRepo.save(cate);

		return "redirect:/admin/categories/index";
		}
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") Categories cate, Model model
			) {
		request.setAttribute("viewManage", "/views/admin/categories/edit.jsp");
		model.addAttribute("cate", cate);
		return "admin/layout/admin";
	}
	
	@PostMapping("update/{id}")
	public String update(@PathVariable("id") Categories c, @Valid @ModelAttribute("cate") CategoryModel ca, BindingResult br) {
		
			if (br.hasErrors() == true) {
			request.setAttribute("viewManage", "/views/admin/categories/edit.jsp");
			return "admin/layout/admin";
			
		} else {
//		Categories cate = this.cateRepo.getById(c);
		

		c.setName(ca.getName());
		this.cateRepo.save(c);

		return "redirect:/admin/categories/index";
		}
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id")  Integer c, Categories cate) {
		System.out.println(cate.getName());
		this.cateRepo.delete(cate);

		return "redirect:/admin/categories/index";
	}
	
	@GetMapping("index")
	public String index(Model model,
			@RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="size", defaultValue = "6") int size
			) {
		request.setAttribute("viewManage", "/views/admin/categories/index.jsp");
		Pageable pageable = PageRequest.of(page, size);
		Page<Categories> p = this.cateRepo.findAll(pageable);
		model.addAttribute("dataCate", p);
		
		return "admin/layout/admin";
	}
	
}
