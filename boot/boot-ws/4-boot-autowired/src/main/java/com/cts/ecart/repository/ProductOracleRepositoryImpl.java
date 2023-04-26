package com.cts.ecart.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
public class ProductOracleRepositoryImpl implements ProductRepository {
	
	@Override
	public void save() {
		System.out.println(">>Repository: Oracle saving product");
	}

	@Override
	public void delete() {
		System.out.println(">>Repository: Oracle deleteing product");
	}
}
