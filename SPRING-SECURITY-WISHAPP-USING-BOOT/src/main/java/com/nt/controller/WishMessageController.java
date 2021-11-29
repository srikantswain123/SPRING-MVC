package com.nt.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.IWishMessageGenerator;

@Controller
public class WishMessageController {
	
	@Autowired
	private IWishMessageGenerator service;
	
	
	@RequestMapping("/welcome")
	public String getHome() {
		return "home";
	}
	
	@RequestMapping("/wmc")
	public String getWishMsg(Map<String,Object> map,HttpSession ses) {
		//use service
		String msg=service.wishMessageGenerator();
	
		map.put("wish", msg);
		map.put("sysDate", new Date());
		System.out.println("time out::"+new Date(ses.getCreationTime())+" /   "+ses.getMaxInactiveInterval() );
		return "result";
		
	}


}
