package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {
	
	@GetMapping("/welcome")
	public String home() {
		return "homePage";
	}
	@GetMapping("/java")
	public String java() {
		return "JavaPage";
	}
	@GetMapping("/dotNet")
	public String dotNet() {
		return "DotNetPage";
	}
	@GetMapping("/oracle")
	public String oracle() {
		return "OraclePage";
	}
}
