package com.nt.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@Autowired
	private ServletContext ctx;
	@Autowired
	private ServletConfig cg;
	
	
	@RequestMapping("/register")
	public String register(HttpSession ses,HttpServletRequest req) {
		System.out.println(ctx.getContextPath());
		System.out.println(cg.getServletName());
		System.out.println(ses.getId());
		System.out.println(req.getRequestURI());
		return "show";
	}

}
