package web;

import domain.Apartment;
import domain.Customer;
import dto.ApartmentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ApartmentService;
import service.CustomerService;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    ApartmentService apartmentService;

    @Autowired
    CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model, final Authentication authentication) {
        Customer customer = (Customer) authentication.getPrincipal();
        model.addAttribute("customer", customer);
        model.addAttribute("apartmentForm", new ApartmentForm());
		model.addAttribute("apartments", customer.getApartments());
		return "main";
	}

    @RequestMapping(value = "/addApartment", method = RequestMethod.POST, produces = "text/html")
    public String save(ApartmentForm apartmentForm, final Authentication authentication) {
        Customer customer = (Customer) authentication.getPrincipal();
        Apartment apartment = apartmentService.save(new Apartment(apartmentForm.getName()));
        customer.addApartment(apartment);
//        Customer savedCustomer = customerService.save(customer);
        return "redirect:/";
    }
}