package web;

import domain.Apartment;
import dto.ApartmentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ApartmentService;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    ApartmentService apartmentService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
        model.addAttribute("apartmentForm", new ApartmentForm());
		model.addAttribute("apartments", apartmentService.findAll());
		return "main";
	}

    @RequestMapping(value = "/addApartment", method = RequestMethod.POST, produces = "text/html")
    public String save(ApartmentForm apartmentForm, BindingResult bindingResult, ModelMap model) {

        apartmentService.save(new Apartment(apartmentForm.getName()));
//        redirectAttributes.addFlashAttribute("successMessage", "Data saved successfully!");
        return "redirect:/";
    }
}