package com.nt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.service.IWishMessageGenerator;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private IWishMessageGenerator service;
	
	
	//@RequestMapping(value = {"welcome","test","view"})
	@RequestMapping("welcome")
	public String getHome() {
		return "home2";
	}
	
	/*@RequestMapping("/wmc")
	public String getWishMsg(Map<String,Object> map) {
		//use service
		String msg=service.wishMessageGenerator();
		map.put("wish", msg);
		map.put("sysDate", new Date());
		return "result";
		
	}*/
	
	/*@RequestMapping(value="register")
	public String showHome(HttpServletRequest req) {
		System.out.println("method type::"+req.getMethod());
		return "home1";
	}*/
	
	/*@RequestMapping(value="register",method = {RequestMethod.POST,RequestMethod.GET})
	public String mainHome(HttpServletRequest req) {
		System.out.println("method type::"+req.getMethod());
		return "home1";
	}*/

}
