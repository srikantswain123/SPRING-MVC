package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.model.CustomerModel;

@Repository("dao")
public class CustomerDaoImpl implements ICustomerDao {
	private static final String query="INSERT INTO CUSTOMER_REGISTRATION VALUES(:cid,:cname,:cadd,:camt)";
	
	@Autowired
	private NamedParameterJdbcTemplate jt;

	@Override
	public int saveCusomerData(CustomerModel model) {
     BeanPropertySqlParameterSource bpspm=new BeanPropertySqlParameterSource(model);
     int count=jt.update(query, bpspm);
		
		return count;
	}

}
