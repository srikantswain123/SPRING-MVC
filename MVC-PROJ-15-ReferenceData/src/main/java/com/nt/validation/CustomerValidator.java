package com.nt.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.CustomerModel;
@Component("validator")
public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("CustomerValidator.supports()");
		return clazz.isAssignableFrom(CustomerModel.class);
	}

	@Override
	public void validate(Object object, Errors error) {
		System.out.println("CustomerValidator.validate()");
		CustomerModel cust=(CustomerModel)object;
		if(cust.getCname()==null||cust.getCname().isBlank())
			error.rejectValue("cname", "cname.empty");
		else if(cust.getCname().length()<5)
			error.rejectValue("cname", "cname.length");
		if(cust.getCadd().isBlank()||cust.getCadd()==null)
			error.rejectValue("cadd", "cadd.empty");
		else if(cust.getCadd().length()<5)
            error.rejectValue("cadd", "cadd.length");
		 if(cust.getCamt()==null)
			error.rejectValue("camt", "camt.empty");
		else if(cust.getCamt()<=0)
			error.rejectValue("camt", "camt.value");
		
		// TODO Auto-generated method stub

	}

}
