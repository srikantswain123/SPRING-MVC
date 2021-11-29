package com.nt.service;

import com.nt.entity.JobSekerEntity;

public interface IJobSeekerService {
	
	public String saveJobSekerData(JobSekerEntity entity);
	public Iterable<JobSekerEntity> fetchAllData();

}
