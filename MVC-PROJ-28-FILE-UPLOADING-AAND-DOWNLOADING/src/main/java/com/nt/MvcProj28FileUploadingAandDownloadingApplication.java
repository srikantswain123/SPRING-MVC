package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class MvcProj28FileUploadingAandDownloadingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcProj28FileUploadingAandDownloadingApplication.class, args);
	}
	
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver res() {
		return new CommonsMultipartResolver();
	}

}
