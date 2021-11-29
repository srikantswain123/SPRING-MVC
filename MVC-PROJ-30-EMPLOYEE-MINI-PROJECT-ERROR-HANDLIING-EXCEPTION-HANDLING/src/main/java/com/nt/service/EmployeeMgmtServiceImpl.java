package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.exception.EmployeNotFoundException;
import com.nt.repo.EmployeeRepo;

@Service("service")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private EmployeeRepo repo;

	@Override
	public Iterable<Employee> fecthEmployeDetails() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Employee fetchEmployeeById(int eno) {
		Optional<Employee> emp=repo.findById(eno);
		if(emp.isPresent())
			return emp.get();
		else
			throw new EmployeNotFoundException("Employee No Found");
	}

	@Override
	public Employee saveObject(Employee emp) {
		//save object
		return repo.save(emp);
	}

	@Override
	public void deleteEmployeeById(int eno) {
		//delete object by id
		repo.deleteById(eno);

	}
	
	@Override
	public Page<Employee> fetchEmployeDetailsByPaging(Pageable pageable) {
		// TODO Auto-generated method stub
		return repo.findAll(pageable);
	}

}
