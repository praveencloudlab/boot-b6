package com.cts.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		 C1 obj1 = context.getBean(C1.class);
		 C1 obj2 = context.getBean(C1.class);
		
		  obj1.test();
		 obj2.test();
		
		//context.close();
		
 	
	}

}
