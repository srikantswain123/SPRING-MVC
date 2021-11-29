package com.nt.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "EMP")
public class EmployeeBo {
	@Id
	@Column(name = "EMPNO")
	private Integer eno;
	@Column(name = "ENAME")
	private String ename;
	@Column(name = "JOB")
	private String job;
	@Column(name = "SAL")
	private Float sal;

}
