package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.dto.EmployeeDto;
import com.nt.service.IEmployeeService;

@Controller
public class MainController {
	
	@Autowired
	private IEmployeeService service;
	
	@RequestMapping("/welcome")
	public String viewHome() {
		return "home";
	}
	
	@RequestMapping("/emps")
	public String empDetials(Map<String,Object> map) {
		//use service here
		List<EmployeeDto> listDto=service.getEmpsDetials();
		map.put("empDetails", listDto);
		return "show";
	}

}
