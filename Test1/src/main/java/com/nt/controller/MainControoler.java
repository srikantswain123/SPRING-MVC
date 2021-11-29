package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.beans.Student;

@Controller
public class MainControoler {
	
	@GetMapping("/welcome")
	public String home(@ModelAttribute("stu") Student st) {
		return "home";
	}
	@PostMapping("/submit")
	public String getResult(@ModelAttribute("stu")Student st,Map<String,Object> map) {
		map.put("result", st);
		return "result";
	}

}
