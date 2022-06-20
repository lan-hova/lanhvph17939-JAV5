package ASM.controllers.admin;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ASM.beans.OrderDetailModel;
import ASM.entities.OrderDetails;
import ASM.entities.Orders;
import ASM.entities.Products;
import ASM.repositories.OrderDetailRepository;
import ASM.repositories.OrderRepository;
import ASM.repositories.ProductRepository;



@Controller
@RequestMapping("/admin/orderDetails")
public class OrderDetailController {
	
	@Autowired
	HttpServletRequest request;
	@Autowired
	private OrderDetailRepository odsRepo;
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private ProductRepository productRepo;
	
	@GetMapping("create")
	public String create(@ModelAttribute("ods") OrderDetailModel ods, Model model) {
		List<Products> ds = this.productRepo.findAll();
		List<Orders> ds2 = this.orderRepo.findAll();
		model.addAttribute("dsProduct", ds);
		model.addAttribute("dsOrder", ds2);
		request.setAttribute("viewManage", "/views/admin/orderDetails/create.jsp");
		return "admin/layout/admin";
	}
	
	@PostMapping("store")
	public String store(OrderDetails model) {
//		OrderDetails ods = new OrderDetails();

//		ods.setOrders(model.getOrders());
//		ods.setProducts(model.getProducts());
//		ods.setPrice(model.getPrice());
//		ods.setQuantity(model.getQuantity());
		
		this.odsRepo.save(model);
		return "redirect:/admin/orderDetails/index";
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") OrderDetails ods, Model model
			) {

		List<Products> ds = this.productRepo.findAll();
		List<Orders> ds2 = this.orderRepo.findAll();
		model.addAttribute("dsProduct", ds);
		model.addAttribute("dsOrder", ds2);
		model.addAttribute("ods", ods);
		
		request.setAttribute("viewManage", "/views/admin/orderDetails/edit.jsp");
		return "admin/layout/admin";
	}
	
	@PostMapping("update/{id}")
	public String update(@PathVariable("id") Integer c, @ModelAttribute("ods") OrderDetailModel od) {
		
		OrderDetails ods = this.odsRepo.getById(c);
		ods.setOrders(od.getOrders());
		ods.setProducts(od.getProducts());
		ods.setPrice(od.getPrice());
		ods.setQuantity(od.getQuantity());
		
		this.odsRepo.save(ods);

		return "redirect:/admin/orderDetails/index";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id")  Integer o, OrderDetails ods) {
		this.odsRepo.delete(ods);
		request.setAttribute("viewManage", "/views/admin/orderDetails/index.jsp");
		return "redirect:/admin/layout/admin";
	}
	
	@GetMapping("index")
	public String index(Model model,
			@RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="size", defaultValue = "6") int size
			) {
		request.setAttribute("viewManage", "/views/admin/orderDetails/index.jsp");
		Pageable pageable = PageRequest.of(page, size);
		Page<OrderDetails> o = this.odsRepo.findAll(pageable);
		model.addAttribute("dataOds", o);
		
		return "admin/layout/admin";
	}
}
