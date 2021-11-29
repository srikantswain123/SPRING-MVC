package com.nt.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.nt.model.Employee;

@Component("excelview")
public class ExcelView extends AbstractXlsView {
	
	private static int i=0;

	@Override
	public void buildExcelDocument(Map<String, Object> map, Workbook book, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		List<Employee> listEmp=(List<Employee>) map.get("emps");
		Sheet sheet=book.createSheet("Employee Report");
		
		listEmp.forEach(emp->{
			Row row=sheet.createRow(i);
			row.createCell(0).setCellValue(emp.getEid());
			row.createCell(1).setCellValue(emp.getEname());
			row.createCell(2).setCellValue(emp.getEadd());
			row.createCell(3).setCellValue(emp.getEamount());
			i++;
		});

	}

}
