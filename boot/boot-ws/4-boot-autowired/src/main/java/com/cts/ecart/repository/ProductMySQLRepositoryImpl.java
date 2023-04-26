package com.cts.ecart.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ProductMySQLRepositoryImpl implements ProductRepository {
	
	@Override
	public void save() {
		System.out.println(">>Repository: MYSQL saving product");
	}

	@Override
	public void delete() {
		System.out.println(">>Repository: MYSQL deleteing product");
	}
}
