package crud;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService mycustomerservice;
	
	@GetMapping("/list")
	public String ListCustomers(Model mymodel) {
		List<Customer> customers =new ArrayList<>();
		
		customers = mycustomerservice.getCustomers();
		
		mymodel.addAttribute("customers",customers);
		
		return "list-customers";
		//return "test";
	}
	
	@GetMapping("/add")
	public String AddCustomer(Model myModel) {
		Customer newcustomer = new Customer() ;
		myModel.addAttribute("customer", newcustomer);
		return "add-customer";
	}
	
	@PostMapping("saveCustomer")
	public String SaveCustomer(@ModelAttribute("customer") Customer customer ) {
		mycustomerservice.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/update")
	public String UpdateCustomer(@RequestParam("customerId") int myId, Model mymodel) {
		Customer mycustomer = mycustomerservice.getCustomer(myId);
		mymodel.addAttribute(mycustomer);
		return "add-customer";
	}
	
	@GetMapping("/delete")
	public String DeleteCustomer(@RequestParam("customerId") int myId, Model mymodel) {
		mycustomerservice.deleteCustomer(myId);
		return "redirect:/customer/list";
		
	}
	

}
