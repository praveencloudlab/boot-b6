package com.cts.ecart.service;

import org.springframework.stereotype.Service;

@Service(value = "prodService")
public class ProductServiceImpl implements ProductService {
	
	@Override
	public void save() {
		System.out.println(">> Saving to DB");
	}

}
