package com.nt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {
	
	public Iterable<Employee> fecthEmployeDetails();
	public Employee fetchEmployeeById(int eno);
	public Employee saveObject(Employee emp);
	public void deleteEmployeeById(int eno);
	public Page<Employee> fetchEmployeDetailsByPaging(Pageable pageable);

}
