package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.service.IwishMessageService;

@Controller
public class WishControoler {
	
	@Autowired
	private IwishMessageService service;

	
	@GetMapping("/welcome")
	public String home() {
		return "home";
	}
	
	@GetMapping("/wish")
	public String wish(Map<String,Object> map) {
		//use service
		String msg=service.getWmsg();
		map.put("msg", msg);
		return "result";
		
	}
}
