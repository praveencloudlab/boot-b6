package com.cts.ecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.cts.ecart.repository.ProductRepository;
@Service
public class ProductServiceImpl { // dependent

	 @Autowired 
	// @Qualifier(value = "productOracleRepositoryImpl")
	 @Qualifier(value = "productMySQLRepositoryImpl")
	private ProductRepository prodRepo; // dependency

	/*
	public ProductServiceImpl(ProductRepository prodRepo) {
		this.prodRepo = prodRepo;
	}
	*/

	public void saveProduct() {
		prodRepo.save();
	}

	public void deleteProduct() {
		prodRepo.delete();
	}

}
