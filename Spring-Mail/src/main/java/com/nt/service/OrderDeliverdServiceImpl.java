package com.nt.service;

import java.util.Arrays;
import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("OrderService")
public class OrderDeliverdServiceImpl implements IOrderDeliverService {
	
	@Autowired
	private JavaMailSender sender;

	@Override
	public String deliverd(String[] items, Float[] prices, String[] sendermails)throws Exception {
		float amt=0.0f;
		for(Float p:prices)
			amt=amt+p;
		String body="Items Are purchased"+Arrays.deepToString(items)+" having prices"+ Arrays.deepToString(prices)+" total Amonut is:"+amt;
		String subject="Open it  to know items";
		//triger mail
		String msg=trigerMail(sendermails, subject, body);
		return msg;
	}
	
	
	//create all sender msg activity
	public String trigerMail(String[] sendermail,String subject,String body)throws Exception {
		//create msg object 
		MimeMessage message=sender.createMimeMessage();
		//create msgHelper object with message param it supports attachment
		MimeMessageHelper helper=new MimeMessageHelper(message, true);
		helper.setBcc(sendermail);
		helper.setSubject(subject);
		helper.setText(body);
		helper.setSentDate(new Date());
		helper.addAttachment("nit.jpg", new ClassPathResource("nit.jpg"));
		sender.send(message);
		return "mail has been delivered";
		
	}

}
