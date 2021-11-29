package com.nt.controller;

import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
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
		return "redirect:show";
	}
	
	
	@GetMapping("/show")
	public String show(HttpSession ses,Map<String,Object> map) {
		
	 ses.setAttribute("min", i);
	  if((int)ses.getAttribute("min")>0) {
		  map.put("result", "Form Already submitted Don't press refresh button");
	  }
	  System.out.println(ses.getAttribute("min"));
	  i=1;
		return "Result";
	}

}
