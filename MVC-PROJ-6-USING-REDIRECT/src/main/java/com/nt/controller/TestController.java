package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("/save")
	public String saveData() {
		return "redirect:show";
	}
	@RequestMapping("/delete")
	public String deleteData() {
		return "redirect:show";
	}
	@RequestMapping("/show")
	public String show() {
		return "show";
	}
	

}
