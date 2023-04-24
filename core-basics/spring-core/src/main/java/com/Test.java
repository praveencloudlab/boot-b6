package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	/*
	 *  Types of Objects? : 2 types
	 *  ==========================
	 *  1.dependency object: works independently. Never depends on other objects
	 *  2.dependent object : always depends on dependency object
	 *  
	 */

	public static void main(String[] args) {
		
		// SOLI - D - 
		
		
		String[] cart1= {"P001","P002"};
		String[] cart2= {"P001","P002","P003"};
		
		ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
		
		// here ac is container 
	
		BillingImpl biller = ac.getBean(BillingImpl.class);
		
			
			
	//=======================================================	
		double total = biller.getCartItemsTotal(cart1);
		System.out.println("Cart1 Total: "+total);

		total=biller.getCartItemsTotal(cart2);
		System.out.println("Cart2 Total: "+total);
	//=======================================================

		

	}

}
