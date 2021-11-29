package com.nt.service;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

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
	
	@Override
	public String[] genders() {
		// TODO Auto-generated method stub
		return new String[] {"male","female"};
	}
	
	
	@Override
	public List<String> hobbies() {
		// TODO Auto-generated method stub
		return List.of("Dancing","movies","drawing","Cricket","Movies","singing");
	}
	
	@Override
	public Set<String> locales() {
		Locale[] locale=Locale.getAvailableLocales();
		Set<String> set=new HashSet();
		for(Locale l:locale) {
			set.add(l.getDisplayCountry());
		}
		return set;
	}
	
	@Override
	public Set<String> languaje() {
		Locale[] locale=Locale.getAvailableLocales();
		Set<String> set=new HashSet();
		for(Locale l:locale) {
			set.add(l.getDisplayLanguage());
		}
		return set;
	}

}
