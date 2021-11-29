package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BOOT_JOBSEKER_DATA")
public class JobSekerEntity implements Serializable {
	@Id
	@GeneratedValue
	private Integer jsid;
    @Column(length = 20)
	private String jsname;
    @Column(length = 20)
    private String jsqlfy;
    @Column(length = 150)
	private String jsphoto;
    @Column(length = 150)
	private String jsresume;

}
