package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Employee;

@Controller
public class MainController {

	@GetMapping("/welcome")
	public String showHome() {
		return "main";
	}

	@GetMapping("/main")
	public String employeeRegister(Map<String,Object> map,@ModelAttribute("emp")Employee emps,@RequestParam String type) {
		List<Employee> emp=List.of(new Employee(101, "Samir", "hyd", 100.0f),
				new Employee(102, "girsih", "delhi", 200.0f),
				new Employee(103, "dinesh", "manali", 300.0f),
				new Employee(104, "mohit", "noida", 400.0f));
		map.put("emps", emp);
		if(type.equalsIgnoreCase("pdf"))
			return "pdfview";
		else
			return "excelview";
	}

}
