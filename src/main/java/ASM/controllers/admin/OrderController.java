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

import ASM.beans.OrderModel;
import ASM.entities.Accounts;
import ASM.entities.Orders;
import ASM.repositories.AccountRepository;
import ASM.repositories.OrderRepository;



@Controller
@RequestMapping("/admin/orders")
public class OrderController {
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private AccountRepository accountRepo;
	
	@GetMapping("create")
	public String create(@ModelAttribute("order") OrderModel order, Model model) {
		List<Accounts> ds = this.accountRepo.findAll();
		model.addAttribute("dsAcc", ds);
		
		request.setAttribute("viewManage", "/views/admin/orders/create.jsp");
		return "admin/layout/admin";
	}
	
	@PostMapping("store")
	public String store(@Valid @ModelAttribute("order") OrderModel model, BindingResult br, Model m ) {
		if (br.hasErrors() == true) {
			List<Accounts> ds = this.accountRepo.findAll();
			m.addAttribute("dsAcc", ds);
			request.setAttribute("viewManage", "/views/admin/orders/create.jsp");
			return "admin/layout/admin";
		} else {
		Orders ord = new Orders();
		
		ord.setAddress(model.getAddress());
		ord.setCreateDate(new Date());
		ord.setAccounts(model.getAccounts());
		
		this.orderRepo.save(ord);

		return "redirect:/admin/orders/index";
		}
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") Orders order, Model model
			) {

		List<Accounts> ds = this.accountRepo.findAll();
		model.addAttribute("dsAcc", ds);
		model.addAttribute("order", order);
		
		request.setAttribute("viewManage", "/views/admin/orders/edit.jsp");
		return "admin/layout/admin";
	}
	
	@PostMapping("update/{id}")
	public String update(@PathVariable("id") Integer c,@Valid @ModelAttribute("order") OrderModel o, BindingResult br, Model model) {
		List<Accounts> ds = this.accountRepo.findAll();
		model.addAttribute("dsAcc", ds);
		if (br.hasErrors() == true) {
			Orders ord = this.orderRepo.getById(c);
			o.setCreateDate(ord.getCreateDate());
			model.addAttribute("order", o);
			request.setAttribute("viewManage", "/views/admin/orders/edit.jsp");
			return "admin/layout/admin";
			
		} else {
		Orders ord = this.orderRepo.getById(c);
		ord.setAddress(o.getAddress());
		ord.setAccounts(o.getAccounts());
		
		this.orderRepo.save(ord);

		return "redirect:/admin/orders/index";
		}
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id")  Integer o, Orders order) {
		this.orderRepo.delete(order);

		return "redirect:/admin/orders/index";
	}
	
	@GetMapping("index")
	public String index(Model model,
			@RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="size", defaultValue = "6") int size
			) { 
		request.setAttribute("viewManage", "/views/admin/orders/index.jsp");
		Pageable pageable = PageRequest.of(page, size);
		Page<Orders> o = this.orderRepo.findAll(pageable);
		model.addAttribute("dataOrder", o);
		
		return "admin/layout/admin";
	}
}
