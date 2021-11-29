package com.nt.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.Employee;

public interface EmployeeRepo extends PagingAndSortingRepository<Employee, Integer> {

}
