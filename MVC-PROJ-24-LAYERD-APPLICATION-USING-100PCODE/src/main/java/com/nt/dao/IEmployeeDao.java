package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBo;

public interface IEmployeeDao {
	
	public List<EmployeeBo> fetchAllEmpDetails();

}
