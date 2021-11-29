package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee implements Serializable {
	@Id
	@GeneratedValue
	private Integer eid;
	private String ename;
	private Float esal;
	private String eadd;
	private String desg;

}
