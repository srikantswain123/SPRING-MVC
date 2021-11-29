package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.nt.controller")
public class DispatcherConfig {
	
	
	//configure Interrnal Resource View Resolver
	
	
	@Bean("ir")
	public InternalResourceViewResolver irvs() {
		InternalResourceViewResolver ir=new InternalResourceViewResolver();
		ir.setPrefix("/WEB-INF/pages/");
		ir.setSuffix(".jsp");
		return  ir;
	}

}
