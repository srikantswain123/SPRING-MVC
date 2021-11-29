package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.entity.JobSekerEntity;
import com.nt.model.JobSekerModel;
import com.nt.service.IJobSeekerService;

@Controller
public class MainController {
	
	@Autowired
	private IJobSeekerService service;
	@Autowired
	private ServletContext sc;
	
	@GetMapping("/upload")
	public String home(@ModelAttribute("job") JobSekerModel model) {
		model.setJsqlfy("Btech");
		return "home";
	}
	
	@PostMapping("/upload")
	public String upload(@ModelAttribute("job") JobSekerModel model,Map<String,Object> map)throws Exception {
		//create folder for server file System
		File file=new File("D:/uploadJob");
		if(!file.exists())
			file.mkdir();
		
		//get names from upload file system
		String photo=model.getJsphoto().getOriginalFilename();
		String resume=model.getJsresume().getOriginalFilename();
		//create upload stream containg model object
		InputStream isPhoto=model.getJsphoto().getInputStream();
		InputStream isResume=model.getJsresume().getInputStream();
		//create out put stream point st servere file system
		OutputStream osPhoto=new FileOutputStream(file.getAbsolutePath()+"/"+photo);
		OutputStream osResume=new FileOutputStream(file.getAbsolutePath()+"/"+resume);
		//save address path in dbs
		JobSekerEntity entity=new JobSekerEntity();
		entity.setJsname(model.getJsname());
		entity.setJsqlfy(model.getJsqlfy());
		entity.setJsphoto(file.getAbsolutePath().replace("\\", "/")+"/"+photo);
		entity.setJsresume(file.getAbsolutePath().replace("\\", "/")+"/"+resume);
		//save object using service
		String result=service.saveJobSekerData(entity);
		//now copy file  for saving server file system
				IOUtils.copy(isPhoto, osPhoto);
				IOUtils.copy(isResume, osResume);
		map.put("result", result);
		isPhoto.close();
		isResume.close();
		osPhoto.close();
		osResume.close();
		return "result";
	}
	
	@GetMapping("/showFile")
	public String showFile(@ModelAttribute("job") JobSekerEntity entity,Map<String,Object> map) {
		Iterable<JobSekerEntity> it=service.fetchAllData();
		map.put("jobdata",it);
		return "download_from";
	}
	@GetMapping("/download")
	public String downloadFile(@RequestParam("fname") String fileName,HttpServletResponse res)throws Exception {
		//create file get file name form dbs and track from server file system
		File file=new File(fileName);
		//set length for download and for fix no other value will go throw download file
		res.setContentLengthLong(file.length());
		//get Mime type
		String mime=sc.getMimeType(fileName);
		//set mime type
		res.setContentType(mime!=null?mime:"application/octet-stream");
		//give instruction to browser for certain containt is download file
		res.addHeader("Content-Disposition", "attachment;fileName="+file.getName());
		//create input stream point to file
		InputStream is=new FileInputStream(file);
		//create output stream pointing response obj
		OutputStream os=res.getOutputStream();
		//make it as copy file to downlaod
		IOUtils.copy(is, os);
		return null;
	}

}
