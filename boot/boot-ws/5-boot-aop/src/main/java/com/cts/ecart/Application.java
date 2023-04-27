package com.cts.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.cts.ecart.service.UserServiceImpl;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		UserServiceImpl userService = context.getBean(UserServiceImpl.class);
		//userService.findAllUsers();
		//userService.findByEmail();
		userService.registerUser("Praveen");
		
		
	}

}
