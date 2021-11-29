package com.nt.dao;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.nt.bo.StudentBo;

public class StudentRegistrationDaoImpl implements IStudentRegistrationDao {
	
	private SimpleJdbcInsert insert;

	public StudentRegistrationDaoImpl(SimpleJdbcInsert insert) {
		this.insert = insert;
	}

	@Override
	public int StiudentRegistration(StudentBo bo) {
		BeanPropertySqlParameterSource map=new BeanPropertySqlParameterSource(bo);
		insert.setTableName("STUDENT_REGISTRATION");
		int update=insert.execute(map);
		// TODO Auto-generated method stub
		return update;
	}

}
