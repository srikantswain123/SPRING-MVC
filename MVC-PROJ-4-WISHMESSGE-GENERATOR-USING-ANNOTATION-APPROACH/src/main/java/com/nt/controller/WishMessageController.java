package com.nt.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.IWishMessageGenerator;

@Controller("webCon")
public class WishMessageController {
	
	@Autowired
	private IWishMessageGenerator service;
	
	
	@RequestMapping("/welcome.htm")
	public String getHome() {
		return "home";
	}
	
	/*@RequestMapping("/wmc.htm")
	public ModelAndView getWishMsg() {
		//use service
		String msg=service.wishMessageGenerator();
				
		return new ModelAndView("result","wish",msg);
	}*/
	/*@RequestMapping("/wmc.htm")
	public String getWishMsg(Model model) {
	    //use  service
		String msg=service.wishMessageGenerator();
		model.addAttribute("wish", msg);
		model.addAttribute("sysDate", new Date());
	return "result";
	          
	}*/
	@RequestMapping("/wmc.htm")
	public String getWishMsg(Map<String,Object> map) {
		//use service
		String msg=service.wishMessageGenerator();
		map.put("wish", msg);
		map.put("sysDate", new Date());
		return "result";
		
	}
	/*@RequestMapping("/wmc.htm")
	public void getWishMsg(Map<String,Object> map) {
		//use service
				String msg=service.wishMessageGenerator();
				map.put("wish", msg);
				map.put("sysDate", new Date());
		
	}*/

}
