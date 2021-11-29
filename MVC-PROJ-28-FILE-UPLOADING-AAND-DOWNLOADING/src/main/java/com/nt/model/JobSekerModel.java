package com.nt.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class JobSekerModel  {
	private Integer jsid;
	private String jsname;
	private String jsqlfy;
	private MultipartFile jsphoto;
	private MultipartFile jsresume;

}
