package com.nt.model;

import java.util.Date;

import lombok.Data;

@Data
public class CustomerModel {
	private Integer cid;
	private String cname;
	private String cadd;
	private Float camt;
	private String vflag="no";
	private String gender="female";
	private String[] hobbies= {"Dancing"};
	private String country="India";
	private String[] langs;
	private Date dob;
	private Date doj=new Date();

}
