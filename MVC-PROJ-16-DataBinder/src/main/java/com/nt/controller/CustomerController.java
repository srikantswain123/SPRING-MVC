package com.nt.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
		String result=service.insertData(model);
		rat.addFlashAttribute("result", result);
		rat.addFlashAttribute("cust", model);
		return "redirect:show";
	}
	
	
	@GetMapping("/show")
	public String show() {
		
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
	
	@InitBinder
	public void myInitBinder(ServletRequestDataBinder binder) {
		System.out.println("CustomerController.myInitBinder()");
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf,true));
	}
	
	
	

}
