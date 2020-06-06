package com.hazkassb.zgigi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hazkassb.zgigi.entities.Customer;
import com.hazkassb.zgigi.services.CustomerService;




@Controller
public class LoadControllers {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/home")
	public String loadIndex() {
		
		
		return "index";
	}
	
	
	@RequestMapping("/gallery")
	public String loadGallery() {
		
		
		return "gallery";
	}
	
//	@Autowired
    MailComponent mailComponent;

	@GetMapping("/contact")
//	@RequestMapping(value="contact", method = RequestMethod.GET)
    public String index(@ModelAttribute Contact contact) {
        return "contact";
    }

    @PostMapping("/contact")
    public String processContact(@Validated Contact contact, RedirectAttributes model, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "index";

        if (mailComponent.sendSimpleMail(contact)) {
            model.addFlashAttribute("classCss", "alert alert-success");
            model.addFlashAttribute("message", "Your message has been sent");
        } else {
            model.addFlashAttribute("classCss", "alert alert-warning");
            model.addFlashAttribute("message", "An unexpected error occurred thank you to repeat your request later");
        }

        return "redirect:/contact";
    }

////	@RequestMapping("/contact")
//	@RequestMapping(value="/contact", method={RequestMethod.GET})
//	public String loadContact(ModelMap modelMap) {
//		
////		modelMap.put("contact", new Contact());
//		
//		
//		return "contact";
//	}
	
	
	
	@RequestMapping("/admin")
	public String loadAdmin(Model model) {
		List<Customer> customers = customerService.getAll();
		model.addAttribute("customers", customers);
		
		String username = "Hamza";
		model.addAttribute("username", username);
		
		return "admin";
	}
	
	@RequestMapping("/getOne")
	@ResponseBody
	public Optional<Customer> getOne(int Id) {
		return customerService.getOne(Id);
	}
	
	@PostMapping("/addNew")
	public String addNew(Customer customer) {
		customerService.addNew(customer);
		return "redirect:/admin/getAll";
	}
	
	
	@RequestMapping(value="/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(Customer customer) {
		customerService.update(customer);
		return "redirect:/admin";
	}
	
	@RequestMapping(value="/delete", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Customer customer) {
		customerService.delete(customer);
		return "redirect:/admin";
	}

}
