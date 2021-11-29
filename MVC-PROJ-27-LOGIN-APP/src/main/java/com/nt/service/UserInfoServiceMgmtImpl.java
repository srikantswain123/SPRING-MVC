package com.nt.service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.UserInfo;

@Service
public class UserInfoServiceMgmtImpl implements IUserServiceMgmt {
	
	
	@Autowired
//	private UserRepo repo;
	private EntityManager em;
	/*
		@Override
		public String UserValidate(UserInfo info) {
			int count=repo.Validate(info.getUser(),info.getPwd());
			return count!=0?"Valid Credential":"Invalid Credential";
		}*/
	
	@Override
	public String UserValidate(UserInfo info) {
		 StoredProcedureQuery pq=em.createStoredProcedureQuery("P_AUTHENTICATION ");
		 pq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		 pq.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		 pq.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
		 
		 //set parameter
		 pq.setParameter(1, info.getUser());
		 pq.setParameter(2, info.getPwd());
		 
   
		return (String) pq.getOutputParameterValue(3);
	}

}
