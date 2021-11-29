package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentController {
	
	@GetMapping("/student")
	public String showHome(@ModelAttribute("stud")Student st) {
		st.setSaddr("hyd");
		return "home";
	}
	
	/*@PostMapping("/student")
	public String getResult(Map<String,Object> map,@ModelAttribute("stud")Student st) {
		map.put("students", st);
		return "result";
	}
	*/
	@PostMapping("/student")
	public String getResult(Map<String,Object> map,@ModelAttribute()Student st) {
		map.put("students", st);
		return "result";
	}

}
