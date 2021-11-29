package com.nt.controller;

import java.time.LocalDate;
import java.util.Formatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.nt.dto.LibraryDto;
import com.nt.service.ILibraryBookMgmt;

@org.springframework.stereotype.Controller("controller")
public class MainController implements Controller {
	
	@Autowired
	private ILibraryBookMgmt service;

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String book=req.getParameter("book");
		String author=req.getParameter("author");
		String date=req.getParameter("date");
		LocalDate ldate=LocalDate.parse(date);
		Float price=Float.parseFloat(req.getParameter("price"));
		//invoke Service
		//create Library Dto Object
		LibraryDto dto=new LibraryDto();
		dto.setBookname(book);
		dto.setAuthorname(author);
		dto.setDate(ldate);
		dto.setPrice(price);
		String result=service.BookInsertion(dto);
		return new ModelAndView("output","library",result);
	}

}
