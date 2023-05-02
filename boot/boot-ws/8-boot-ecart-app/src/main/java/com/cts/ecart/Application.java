package com.cts.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cts.ecart.repository.BrandRepository;
import com.cts.ecart.repository.ProductRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		ProductRepository prodDao = context.getBean(ProductRepository.class);
		BrandRepository brandRepo = context.getBean(BrandRepository.class);
		//prodDao.findAll().forEach(System.out::println);
		
		brandRepo.findAll().forEach(System.out::println);
		
		
		
	}

}
