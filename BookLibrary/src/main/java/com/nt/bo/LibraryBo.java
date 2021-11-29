package com.nt.bo;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class LibraryBo implements Serializable {
	private String bookname;
	private String authorname;
	private LocalDate date;
	private Float price;

}
