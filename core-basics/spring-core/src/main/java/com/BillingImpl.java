package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//dependent class
@Component
public class BillingImpl {
	
	/*
	 * 	Design issues
	 * 	=====================
	 *  -> too many dependency objects
	 *  	-> Performance goes down
	 *  	-> memory issues
	 *  
	 *  why this issues happened?
	 *  ============================
	 *  -> dependent class creating dependency objects directly
	 *  
	 *  What is the solution?
	 *  =========================
	 *  -> Never create dependency objects in the dependent class
	 *  -> Use techniques like JNDI .. etc
	 * 		-> location of JNDI is tightly coupled with dependent class
	 * 
	 *  what is best solution?
	 *  =========================
	 *  -> do not create / look up, instead ask some one (container) to inject: IoC (Inversion of Control)
	 * 
	 *  How to implement IoC?
	 *  ===========================
	 *  -> use any dependency  injection techniques
	 *  
	 *  what is dependency injection?
	 *  ==============================
	 *  -> injecting / passing dependency object to the dependent object
	 *  
	 *  How to implement DI? : 2 ways
	 *  =======================================
	 *  
	 *   way-1 : using setter based injection
	 *   way-2 : using constructor based injection
	 *   
	 *   
	 *   way-1 : using setter based injection
	 *   =======================================
	 *   1. define / declare dependency object reference at the top of dependent class
	 * 	 2. create setter method to the above defined reference
	 *  
	 *  
	 *  	
	 * 
	 * 
	 */
	
	
	@Autowired
	private PriceMatrixImpl price; // dependency

	


	public double getCartItemsTotal(String[] cart) {

		
		//PriceMatrixImpl price = new PriceMatrixImpl(); //dependency

		double total = 0.0;

		for (String itemCode : cart) {
			total = total + price.getItemPrice(itemCode);
		}
		
		return total;

	}
}
