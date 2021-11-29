package com.nt.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class StudentDto implements Serializable {
	
	private Integer sid;
	private String sname;
	private String fname;
	private String mname;
	private LocalDate dob;
	private String addrs;
	private String ms;
	private Integer pin;
	

}
