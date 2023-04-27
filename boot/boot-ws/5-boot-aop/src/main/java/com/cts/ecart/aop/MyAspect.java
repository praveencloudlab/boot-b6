package com.cts.ecart.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	
	/*
	@Before("execution(* com.cts.ecart.service.*ServiceImpl.find*())")
	public void f1(JoinPoint jp) {
		System.out.println(">>> find method about to invoke on "+jp.getSignature());
	}
	
	@After("execution(* com.cts.ecart.service.*ServiceImpl.find*())")
	public void f2() {
		System.out.println(">>> find method executed...");
	}
	*/
	
	@Around("execution(* com.cts.ecart.service.*ServiceImpl.register*(*))")
	public void f3(ProceedingJoinPoint pj) throws Throwable {
		
		System.out.println(">> Around advice ....");
		
		// if conditions ...
		
		Object obj = pj.proceed();
		
		System.out.println(">> Transaction completed successfully. "+obj+" registered..");
		
		
		
		
	}
	
	
	
	

}
