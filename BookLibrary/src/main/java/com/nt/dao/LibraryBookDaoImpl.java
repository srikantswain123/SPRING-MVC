package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.LibraryBo;

@Repository("dao")
public class LibraryBookDaoImpl implements ILibraryBookDao {
	private static final String Query="INSERT INTO LIBRARY VALUES(SEQ_LIB.NEXTVAL,:BOOK,:AUTHOR,:PUBLISH,:PRICE)";
	@Autowired
	private NamedParameterJdbcTemplate jt;

	@Override
	public int bookSave(LibraryBo bo) {
		MapSqlParameterSource map=new MapSqlParameterSource();
		map.addValue("BOOK", bo.getBookname());
		map.addValue("AUTHOR", bo.getAuthorname());
		map.addValue("PUBLISH", bo.getDate());
		map.addValue("PRICE", bo.getPrice());
		int update=jt.update(Query, map);
		return update;
	}

}
