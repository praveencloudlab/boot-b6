package com.cts.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySources;

import com.cts.ecart.dao.ProductDaoImpl;
import com.cts.ecart.model.Product;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		ProductDaoImpl prodDao = context.getBean(ProductDaoImpl.class);
		//prodDao.f1(11);
		//prodDao.f2();
		//prodDao.f3().forEach(System.out::println);
		/*
		Product prod = prodDao.f4(1);
		if(prod!=null) {
			System.out.println(prod);
		}else {
			System.out.println("some issue while fetching..");
		}
		*/
		
		/*
		Product prod = prodDao.f5(1);
		if(prod!=null) {
			System.out.println(prod);
		}else {
			System.out.println("some issue while fetching..");
		}
		*/
		
		prodDao.f6().forEach(System.out::println);
		
	}

}
