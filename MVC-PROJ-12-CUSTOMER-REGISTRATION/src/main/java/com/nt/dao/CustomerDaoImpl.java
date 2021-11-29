package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.model.CustomerModel;

@Repository("dao")
public class CustomerDaoImpl implements ICustomerDao {
	
	@Autowired
	private SimpleJdbcInsert jt;

	@Override
	public int saveCusomerData(CustomerModel model) {
     jt.setTableName("CUSTOMER_REGISTRATION");
     BeanPropertySqlParameterSource bpspm=new BeanPropertySqlParameterSource(model);
     int count=jt.execute(bpspm);
		
		return count;
	}

}
