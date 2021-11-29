package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBo;
@Repository("empDao")
public class EmployeeDaoImpl implements IEmployeeDao {
	private static final String query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP";
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<EmployeeBo> fetchAllEmpDetails() {
		List<EmployeeBo> listBo=jt.query(query, rs->{
			List<EmployeeBo> list=new ArrayList();
			while(rs.next()) {
				EmployeeBo bo=new EmployeeBo();
				bo.setEno(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getFloat(4));
				list.add(bo);
			}
			return list;
		});
		return listBo;
	}//method

}//class
