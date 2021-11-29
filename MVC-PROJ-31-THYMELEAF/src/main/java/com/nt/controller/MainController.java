package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
@RequestMapping("/employee")
public class MainController {
	
	
	@Autowired
	private IEmployeeMgmtService service;
	
	@GetMapping("/welcome")
	public String home() {
		return "home";
	}
	private static int i=0;
	private static int j=0;
	
	@GetMapping("/employeeDetials")
	public  String allEmployeDetails(Map<String,Object> map) {
		//user service
		Iterable<Employee> it=service.fecthEmployeDetails();
		map.put("empList", it);
		i=1;
		return "emplist_result";
	}
	
	@GetMapping("/edit")
	public String editForm(@ModelAttribute("emp") Employee emps,@RequestParam("no") int eno) {
		Employee emp=service.fetchEmployeeById(eno);
		BeanUtils.copyProperties(emp, emps);
		return "edit_form";
	}
	
	@PostMapping("/edit")
	public String updateEmployee(@ModelAttribute("emp") Employee emps,RedirectAttributes attr) {
		//use service for update Employee
		Employee es=service.saveObject(emps);
		attr.addFlashAttribute("updateResult", es.getEid()+" Employee Updated SucessFully");
		if(i==1)
		return "redirect:employeeDetials";
		else 
			return "redirect:report_paging";
	}
	
	@GetMapping("/delete")
	public String deleteEmployeeById(@RequestParam("no") int eno,RedirectAttributes attrs) {
		//use service for delete object
		service.deleteEmployeeById(eno);
		attrs.addFlashAttribute("deleteObject", eno+" Id Based Employee Deleted Sucessfully");
		if(i==1)
			return "redirect:employeeDetials";
			else 
				return "redirect:report_paging";
	}
	
	@GetMapping("/report_paging")
	public String showEmployeeByPaging(@PageableDefault(page = 0,size = 3,direction = Direction.DESC,sort = "ename")Pageable pageable,Map<String,Object> map) {
		//use Service
		Page<Employee> page=service.fetchEmployeDetailsByPaging(pageable);
		map.put("pageEmpList", page);
		return "emp_paging_result";
	}
	

}
