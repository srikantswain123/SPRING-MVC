package com.nt.model;

import lombok.Data;

@Data
public class CustomerModel {
	private Integer cid;
	private String cname;
	private String cadd;
	private Float camt;
	private String vflag="no";

}
