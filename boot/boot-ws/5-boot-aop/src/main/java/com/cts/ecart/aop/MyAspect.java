package com.cts.ecart.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
    private static final Logger logger = LoggerFactory.getLogger(MyAspect.class);
	
	
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
        logger.info("Around Advice is initiated....");
        logger.error("Error.. can not implement code of ...");
        logger.debug("Try to use this solution...");
        
       


		
		// if conditions ...
		
		Object obj = pj.proceed();
		
		System.out.println(">> Transaction completed successfully. "+obj+" registered..");
		
		
		
		
	}
	
	
	
	

}
