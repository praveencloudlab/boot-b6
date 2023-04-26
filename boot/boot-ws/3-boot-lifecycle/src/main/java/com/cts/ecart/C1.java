package com.cts.ecart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
//@Scope("singleton")
@Scope("prototype")
@Lazy(value = false)
//@Lazy(value = true)

public class C1 {
	
	
	public C1() {
		System.out.println("1 >> C1 class constructor on "+System.identityHashCode(this));
	}
	
	public void test() {
		System.out.println("C1 class test method on "+System.identityHashCode(this));
	}
	
	
	
	@PostConstruct
	public void f1() {
		System.out.println("2 >> post-construct on "+System.identityHashCode(this));
	}
	
	
	@Bean(destroyMethod = "clearCache")
	/*
	 * 1.will create separate new object upon every getBean method
	 * 2. bean scope will not work on lazy technique
	 */
	void f2() {
		System.out.println("3 >> bean method on "+System.identityHashCode(this));
	}
	
	@PreDestroy // @PreDestroy will not work on prototype scope
	public void f3() {
		System.out.println("4 >> pre-destroy method on "+System.identityHashCode(this));
	}
	

	

	
}
