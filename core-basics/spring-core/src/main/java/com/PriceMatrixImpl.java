package com;

import org.springframework.stereotype.Component;

// dependency class
@Component
public class PriceMatrixImpl {
	public PriceMatrixImpl() {
		System.out.println("PriceMatrixImpl object created....");
	}

	public double getItemPrice(String itemCode) {

		// code to fetch item price from database

		return 100.00;
	}

}
