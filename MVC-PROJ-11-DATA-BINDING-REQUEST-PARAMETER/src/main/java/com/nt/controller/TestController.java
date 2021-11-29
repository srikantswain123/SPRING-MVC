package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	
	/*@GetMapping("/student")
	public String readData(Map<String,Object> map,@RequestParam("sno") int no,@RequestParam("sname") String name) {
		map.put("snoo", no);
		map.put("snamee", name);
		return"result";
	}*/
	
	/*@GetMapping("/student")
	public String readData(Map<String,Object> map,@RequestParam int sno,@RequestParam(required = false,defaultValue = "anynomus") String sname) {
		map.put("snoo", sno);
		map.put("snamee", sname);
		return"result";
	}*/
	/*@GetMapping("/student")
	public String readData(Map<String,Object> map,@RequestParam int sno,@RequestParam String sname,@RequestParam String subject) {
		map.put("snoo", sno);
		map.put("snamee", sname);
		map.put("subject", subject);
		return"result";
	}*/
	
	/*@GetMapping("/student")
	public String readData(Map<String,Object> map,@RequestParam int sno,@RequestParam String sname,@RequestParam String[] subject) {
		map.put("snoo", sno);
		map.put("snamee", sname);
		map.put("subject", subject);
		return"result";
	}*/
	/*@GetMapping("/student")
	public String readData(Map<String,Object> map,@RequestParam(required = false,defaultValue = "0") int sno,@RequestParam String sname) {
		map.put("snoo", sno);
		map.put("snamee", sname);
		return"result";
	}*/
	
	@GetMapping("/student")
	public String readData(Map<String,Object> map,@RequestParam(required = false)Integer sno,@RequestParam String sname) {
		map.put("snoo", sno);
		map.put("snamee", sname);
		return"result";
	}
}
