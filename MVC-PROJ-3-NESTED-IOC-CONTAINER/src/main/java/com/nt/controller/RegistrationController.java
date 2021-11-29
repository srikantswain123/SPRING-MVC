package com.nt.controller;

import java.time.LocalDate;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.nt.dto.StudentDto;
import com.nt.service.IstudentServiceMgmt;

public class RegistrationController implements Controller {
	
	private IstudentServiceMgmt service;
	

	public RegistrationController(IstudentServiceMgmt service) {
		this.service = service;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String name=req.getParameter("sname");
		String fname=req.getParameter("fname");
	    String mname=req.getParameter("mname");
	    String dob=req.getParameter("dob");
	    String addrs=req.getParameter("addrs");
	    String ms=req.getParameter("ms");
	    int pin=Integer.parseInt(req.getParameter("pin"));
	    StudentDto dto=new StudentDto();
	    dto.setSid(new Random().nextInt(10000));
	    dto.setSname(name);
	    dto.setFname(fname);
	    dto.setMname(mname);
	    dto.setAddrs(addrs);
	    dto.setDob(LocalDate.parse(dob));
	    dto.setMs(ms);
	    dto.setPin(pin);
	    
	    //invoke service class method
	    String result=service.StudentDataSaved(dto);
	    
		return new ModelAndView("output","result",result);
	}

}
