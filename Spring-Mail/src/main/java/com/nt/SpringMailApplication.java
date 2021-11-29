package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.IOrderDeliverService;

@SpringBootApplication
public class SpringMailApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx=SpringApplication.run(SpringMailApplication.class, args);
		try {
		//use service
		IOrderDeliverService service=ctx.getBean("OrderService",IOrderDeliverService.class);
		//invoke business method
		System.out.println(service.deliverd(new String[] {"Fridge","AC","INVOTER"},
				new Float[] {15000.0f, 2000.0f,30000.0f},
				new String[] {"srikantswain4@gmail.com","swainpinu3@gmail.com","sudhir917828@gmail.com"}));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//close appication container
		((ConfigurableApplicationContext) ctx).close();
	}

}
