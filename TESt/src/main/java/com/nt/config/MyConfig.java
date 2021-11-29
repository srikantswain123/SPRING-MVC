package com.nt.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.nt.controller.MainControoler;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.nt.controller")
public class MyConfig {
	
	@Bean("mappin")
	public RequestMappingHandlerMapping mapping() {
		RequestMappingHandlerMapping map=new RequestMappingHandlerMapping();
		return map;
	}
	
	@Bean("messageSource")
	public ResourceBundleMessageSource source() {
		ResourceBundleMessageSource src=new ResourceBundleMessageSource();
		src.setBasename("com/nt/commons/info");
		return src;
	}
	
	@Bean("localeResolver")
	public SessionLocaleResolver resolver() {
		SessionLocaleResolver res=new SessionLocaleResolver();
		res.setDefaultLocale(Locale.US);
		return res;
	}
	
	@Bean("lci")
	public LocaleChangeInterceptor interceptor() {
		LocaleChangeInterceptor lci=new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}
}
