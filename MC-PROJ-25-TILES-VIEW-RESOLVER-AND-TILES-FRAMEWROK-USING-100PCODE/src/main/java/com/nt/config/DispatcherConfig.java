package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.nt.controller")
public class DispatcherConfig {
	
	@Bean("cfgs")
	//activate Tiles Configuration
	public TilesConfigurer cfg() {
		TilesConfigurer cfgs=new TilesConfigurer();
		cfgs.setDefinitions(new String[] {"/WEB-INF/tiles.xml"});
		return cfgs;
	}
	//cfg tiles view Resolver
	@Bean("tvr")
	public TilesViewResolver tvr() {
		return new TilesViewResolver(); 
	}
	
	

}
