package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.LibraryBo;
import com.nt.dao.ILibraryBookDao;
import com.nt.dto.LibraryDto;

@Service("service")
public class LibraryBookMgmt implements ILibraryBookMgmt {
	
	@Autowired
	private ILibraryBookDao dao;

	@Override
	public String BookInsertion(LibraryDto dto) {
		LibraryBo bo=new LibraryBo();
		BeanUtils.copyProperties(dto, bo);
	     int result=dao.bookSave(bo);
		return result!=0?"Object saved Properly":"Problem Towards saving Object";
	}

}
