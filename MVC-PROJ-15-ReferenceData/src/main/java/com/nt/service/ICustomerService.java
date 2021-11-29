package com.nt.service;

import java.util.List;
import java.util.Locale;
import java.util.Set;

import com.nt.model.CustomerModel;

public interface ICustomerService {
	
	public String insertData(CustomerModel model);
	public String[] genders();
	public List<String> hobbies();
	public Set<String> locales();
	public Set<String> languaje();

}
