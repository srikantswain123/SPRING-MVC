package com.nt.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	
	@GetMapping("/customer")
	public String showHome(@ModelAttribute("cust") CustomerModel model) {
		model.setCid(new Random().nextInt(1000));
		model.setCadd("hyd");
		return "home";
	}
	
	@PostMapping("/customer")
	public String saveData(Map<String,Object> map,@ModelAttribute("cust") CustomerModel model,BindingResult error) {
		
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
		map.put("result", result);
		return "Result";
	}

}
