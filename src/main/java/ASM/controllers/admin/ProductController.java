package ASM.controllers.admin;

import java.util.Date;
import java.util.List;

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

import ASM.beans.ProductModel;
import ASM.entities.Categories;
import ASM.entities.Products;
import ASM.repositories.CategoryRepository;
import ASM.repositories.ProductRepository;


@Controller
@RequestMapping("/admin/products")
public class ProductController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private CategoryRepository categoryRepo;
	
	@GetMapping("create")
	public String create(@ModelAttribute("pro") ProductModel pro, Model model) {
		request.setAttribute("viewManage", "/views/admin/products/create.jsp");
		List<Categories> ds = this.categoryRepo.findAll();
		model.addAttribute("dsCategory", ds);
		return "admin/layout/admin";
	}
	
	@PostMapping("store")
	public String store(@Valid @ModelAttribute("pro") ProductModel model, BindingResult br, Model m ) {
		List<Categories> ds = this.categoryRepo.findAll();
		m.addAttribute("dsCategory", ds);
		
		if (br.hasErrors() == true) {
			request.setAttribute("viewManage", "/views/admin/products/create.jsp");
			return "admin/layout/admin";
		} else {

		Products pro = new Products();
		Date now = new Date();
		
		pro.setName(model.getName());
		pro.setPrice(model.getPrice());
		pro.setImage(model.getImage());
		pro.setCategories(model.getCategories());
		pro.setCreatedDate(now);
		
		this.productRepo.save(pro);
		
		return "redirect:/admin/products/index";
		}
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") Products pro, Model model
			) {
		request.setAttribute("viewManage", "/views/admin/products/edit.jsp");
		List<Categories> ds = this.categoryRepo.findAll();
		model.addAttribute("dsCategory", ds);
		model.addAttribute("pro", pro);
		return "admin/layout/admin";
	}
	
	@PostMapping("update/{id}")
	public String update(@PathVariable("id") Products pr, @Valid @ModelAttribute("pro") ProductModel p, BindingResult br, Model model) {
		List<Categories> ds = this.categoryRepo.findAll();
		model.addAttribute("dsCategory", ds);
		if (br.hasErrors() == true) {
		request.setAttribute("viewManage", "/views/admin/products/edit.jsp");
		return "admin/layout/admin";
		
	} else {

		pr.setName(p.getName());
		pr.setImage(p.getImage());
		pr.setPrice(p.getPrice());
		pr.setAvailable(p.getAvailable());
		pr.setCategories(p.getCategories());
		
		this.productRepo.save(pr);
		return "redirect:/admin/products/index";
		}
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id")  Integer c, Products pro) {
		
		System.out.println(pro.getName());
		this.productRepo.delete(pro);
		return "redirect:/admin/products/index";
	}
	
	@GetMapping("index")
	public String index(Model model,
			@RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="size", defaultValue = "6") int size
			) {
		request.setAttribute("viewManage", "/views/admin/products/index.jsp");
		Pageable pageable = PageRequest.of(page, size);
		Page<Products> p = this.productRepo.findAll(pageable);
		model.addAttribute("dataPro", p);
		
		return "admin/layout/admin";
	}
}
