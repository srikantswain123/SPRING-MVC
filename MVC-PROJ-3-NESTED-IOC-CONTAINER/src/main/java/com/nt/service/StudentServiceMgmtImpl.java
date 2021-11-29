package com.nt.service;

import org.springframework.beans.BeanUtils;

import com.nt.bo.StudentBo;
import com.nt.dao.IStudentRegistrationDao;
import com.nt.dto.StudentDto;

public class StudentServiceMgmtImpl implements IstudentServiceMgmt {
	
	private IStudentRegistrationDao dao;
	

	public StudentServiceMgmtImpl(IStudentRegistrationDao dao) {
		this.dao = dao;
	}


	@Override
	public String StudentDataSaved(StudentDto dto) {
		StudentBo bo=new StudentBo();
		BeanUtils.copyProperties(dto, bo);
		//invoke dao
		int result=dao.StiudentRegistration(bo);
		return result!=0?"Registration sucessded":"Registration Failed";
	}

}
