package com.nt.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nt.model.Customer;

@Controller
public class CustomerControoler {
	
	
	@GetMapping("/customer")
	public String showForm(@ModelAttribute("cust")Customer model,Map<String,Object> map) {
		map.put("sysdate", new Date());
		map.put("amount", 100000);
		
		model.setCadd("hyd");
		return "customer_form";
	}

}
