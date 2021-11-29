package com.nt.repo;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.JobSekerEntity;

public interface IJobSeekerRepo extends CrudRepository<JobSekerEntity, Integer> {

}
