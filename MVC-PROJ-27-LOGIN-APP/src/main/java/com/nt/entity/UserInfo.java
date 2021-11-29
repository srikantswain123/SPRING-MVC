package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "USERINFO")
public class UserInfo implements Serializable {
	@Id
	@Column(name="UNAME")
  private String user;
	@Column(name="PWD")
  private String pwd;
}
