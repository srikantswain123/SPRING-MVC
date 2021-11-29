package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSekerEntity;
import com.nt.repo.IJobSeekerRepo;

@Service("service")
public class JobSeekerServiceImpl implements IJobSeekerService {
	
	@Autowired
	private IJobSeekerRepo repo;

	@Override
	public String saveJobSekerData(JobSekerEntity entity) {
		JobSekerEntity ent=repo.save(entity);
		
		return entity.getJsid()!=null?"JobSeekerFileUploadedSucessfuly  having id::"+entity.getJsid():"Problem towards saving job seeker data";
	}
	
	
	@Override
	public Iterable<JobSekerEntity> fetchAllData() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
