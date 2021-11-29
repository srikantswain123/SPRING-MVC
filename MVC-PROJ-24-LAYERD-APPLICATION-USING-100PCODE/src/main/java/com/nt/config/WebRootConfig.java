package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@ComponentScan(basePackages = {"com.nt.service","com.nt.dao"})
@PropertySource("classpath:com/nt/commons/jndi.properties")
public class WebRootConfig {
	
	@Autowired
	private Environment env;
     
	@Bean("jf")
	public JndiObjectFactoryBean jn() {
		JndiObjectFactoryBean jf=new JndiObjectFactoryBean();
		jf.setJndiName(env.getRequiredProperty("jndi"));
		return jf;
	}
	
	@Bean("jt")
	public JdbcTemplate jt() {
		JdbcTemplate jt=new JdbcTemplate();
		jt.setDataSource((DataSource)jn().getObject());
		return jt;
	}
	

	

}
