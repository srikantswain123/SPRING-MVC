package com.nt.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.CustomerModel;
import com.nt.service.ICustomerService;
import com.nt.validation.CustomerValidator;

@Controller
public class CustomerController {
	
	//inject service
	@Autowired
	private ICustomerService service;
	@Autowired
	private CustomerValidator validator;
	@Autowired
	private HttpSession ses;
	static int i=0;
	@GetMapping("/customer")
	public String showHome(@ModelAttribute("cust") CustomerModel model) {
		model.setCadd("hyd");
		return "home";
	}
	
	@PostMapping("/customer")
	public String saveData(RedirectAttributes rat,@ModelAttribute("cust") CustomerModel model,BindingResult error) {
		
		if(model.getVflag().equalsIgnoreCase("no")) {
		//check service side validator
		if(validator.supports(model.getClass()))
			validator.validate(model,error);
		if(error.hasErrors())
			return "home";
		}
		
		if(model.getCamt()>100000) {
			error.rejectValue("camt", "camt.big");
			return "home";
		}
		
		
		//use service
		i=0;
		String result=service.insertData(model);
		rat.addFlashAttribute("result", result);
		rat.addFlashAttribute("cust", model);
		return "redirect:show";
	}
	
	
	@GetMapping("/show")
	public String show(Map<String,Object> map) {
		
	 ses.setAttribute("min", i);
	  if((int)ses.getAttribute("min")>0) {
		  map.put("result", "Form Already submitted Don't press refresh button");
	  }
	  System.out.println(ses.getAttribute("min"));
	  i=1;
		return "Result";
	}
	
	@ModelAttribute("genderList")
	public String[] populateGender() {
		return service.genders();
	}
	
	@ModelAttribute("hobbiesList")
	public List<String> populateHobies() {
		return service.hobbies();
	}
	
	@ModelAttribute("countryList")
	public Set<String> locales(){
		return service.locales();
	}
	
	@ModelAttribute("languajeList")
	public Set<String> populateLanguaje(){
		return service.languaje();
	}
	@ModelAttribute("colorList")
	public List<String> fvco(){
		return List.of("red","green","yellow");
	}
	
	
	

}
