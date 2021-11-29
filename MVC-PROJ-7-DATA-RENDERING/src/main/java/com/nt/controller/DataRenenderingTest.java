package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.dto.Employee;

@Controller
public class DataRenenderingTest {
	
	@RequestMapping("/view")
	public String sendDate(Map<String,Object> map) {
		List<String> books=List.of("java","python","php");
		Set<Long> numbers=Set.of(6549789l,187987671l,2484818l);
		Map<String,String> author=Map.of("java","james gossling","python","robert hooks","php","john cristofa");
		String colors[]= {"orange","pink","black"};
		
	
		map.put("books", books);
		map.put("numbers", numbers);
		map.put("author", author);
		map.put("colors", colors);
		map.put("employee", Map.of("emp1",new Employee(101,"jagdeep",5000.0f),"emp2",new Employee(102,"john",15000.0f),"emp3",new Employee(103,"allen",65000.0f)));
		
		
		return "show";
		
	}

}
