package com.nt.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nt.config.DispatcherConfig;
import com.nt.config.WebRootConfig;

public class Myinitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		//create parent container with webRootConfiguration
		AnnotationConfigWebApplicationContext pCo=new AnnotationConfigWebApplicationContext();
		pCo.register(WebRootConfig.class);
		//create Listner Object with parent container
		ContextLoaderListener cl=new ContextLoaderListener(pCo);
		//aad listner to context 
		sc.addListener(cl);
		
		//ceate child container with Dispatcher Configure
		AnnotationConfigWebApplicationContext cCo=new AnnotationConfigWebApplicationContext();
		cCo.register(DispatcherConfig.class);
		//add child container to dispacther servlet
		DispatcherServlet ds=new DispatcherServlet(cCo);
		//register ds 
		ServletRegistration.Dynamic dyna=sc.addServlet("ds",ds);
		dyna.addMapping("/");
		dyna.setLoadOnStartup(2);

	}

}
