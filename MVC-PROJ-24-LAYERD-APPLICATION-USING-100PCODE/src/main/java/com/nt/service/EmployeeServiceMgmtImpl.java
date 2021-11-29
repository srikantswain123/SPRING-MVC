package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBo;
import com.nt.dao.IEmployeeDao;
import com.nt.dto.EmployeeDto;
 @Service("empService")
public class EmployeeServiceMgmtImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeDao dao;
	
	
	@Override
	public List<EmployeeDto> getEmpsDetials() {
		List<EmployeeBo> listBo=dao.fetchAllEmpDetails();
		  List<EmployeeDto> listDto=new ArrayList();
		  listBo.forEach(row->{
			  EmployeeDto dto=new EmployeeDto();
			  BeanUtils.copyProperties(row, dto);
			  dto.setSal(Math.round(row.getSal()));
			  listDto.add(dto);
		  });
		return listDto;
	}

}
