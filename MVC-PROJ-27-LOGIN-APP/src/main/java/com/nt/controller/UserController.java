package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.entity.UserInfo;
import com.nt.service.IUserServiceMgmt;

@Controller
public class UserController {
	@Autowired
	private IUserServiceMgmt service;
	
	//method for home page
	@GetMapping("/welcome")
	public String home(@ModelAttribute("user")UserInfo info) {
		return "home";
	}
	
	@PostMapping("/welcome")
	public String validate(Map<String,Object> map,@ModelAttribute("user")UserInfo info) {
		//user Servie
		String result=service.UserValidate(info);
		map.put("result", result);
		
		return "home";
	}
	


}
