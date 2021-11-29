package com.nt.controller;

import java.util.Arrays;
import java.util.Locale;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.nt.service.IAllLanguageService;

public class LanguajeController implements Controller {
	
	private IAllLanguageService service;
	

	public LanguajeController(IAllLanguageService service) {
		this.service = service;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TreeSet set=service.getLanguajes();
		return new ModelAndView("result","lang",set);
	}

}
