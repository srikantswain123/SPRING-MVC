package com.nt.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.model.Employee;

@Component("pdfview")
public class PdfView extends AbstractPdfView{
	
	public PdfView() {
		System.out.println("PdfView.PdfView()");
	}
	
	@Override
	public void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter arg2, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
       List<Employee> listEmp=(List<Employee>) map.get("emps");
       
       //create paragraph
       Paragraph para=new Paragraph("Employee Report", new Font(Font.BOLD)); 
       doc.add(para);
       Table table=new Table(4, listEmp.size());
       for(Employee emp:listEmp) {
    	   table.addCell(String.valueOf(emp.getEid()));
    	   table.addCell(String.valueOf(emp.getEname()));
    	   table.addCell(emp.getEadd());
    	   table.addCell(String.valueOf(emp.getEamount()));
       }
       doc.add(table);
	}
}
