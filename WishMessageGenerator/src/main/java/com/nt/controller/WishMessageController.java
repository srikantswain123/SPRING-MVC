package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.nt.service.IWishMessageGenerator;

public class WishMessageController implements Controller {
	
	private IWishMessageGenerator gen;

	public WishMessageController(IWishMessageGenerator gen) {
		this.gen = gen;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("result","wish",gen.wishMessageGenerator());
	}

}
