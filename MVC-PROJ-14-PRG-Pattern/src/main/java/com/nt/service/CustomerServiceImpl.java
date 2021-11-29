package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.ICustomerDao;
import com.nt.model.CustomerModel;

@Service("service")
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerDao dao;

	@Override
	public String insertData(CustomerModel model) {
		int count=dao.saveCusomerData(model);
		return count==0?"Registration failed":"Registration suceded";
	}

}
