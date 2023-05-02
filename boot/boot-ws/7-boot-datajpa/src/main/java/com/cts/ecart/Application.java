package com.cts.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cts.ecart.entity.Product;
import com.cts.ecart.entity.ProductRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		ProductRepository prodDao = context.getBean(ProductRepository.class);
		
		Product prod=new Product();
		//prod.setProductId(203);
		prod.setProductName("Samsung Tab");
		prod.setPrice(111111);
		
		prodDao.save(prod);
		
		
		
		//prodDao.findAll().forEach(System.out::println);
		
	}

}
