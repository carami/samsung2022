package com.sample.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.sample.domain.Product;

@Aspect
@Component
public class MyFirstAspectJavaConfig {
	@Pointcut("execution(* findProduct(String))")
	private void pc() {}
	
	
	@Before("execution(* findProduct(String))")
	public void before(JoinPoint jp) {
		System.out.println("Hello Before!!!   ******   메소드가 호출되기 전에 실행됩니다!!");
		Signature sig =	jp.getSignature();
		System.out.println("-----> 메소드명 : " + sig.getName());
		Object[] o = 	jp.getArgs();
		for (Object object : o) {
			System.out.println("--->인수 :: "+object);
		}
	}
	@After(value="pc()")
	public void after() {
		System.out.println("Hello After!  ***  메소드가 호출된 후에 실행됩니다...");
	}
	
	@AfterReturning(value = "pc()", returning = "product")
	public void afterReturning(JoinPoint jp, Product product) {
		//메소드가 실행된 후 예외를 내보내지 않고 종료 했을 때 실행되는 어드바이스
		System.out.println("Hello AfterReturning!  ***  메소드가 호출된 후에 실행됩니다...");
		Signature sig =	jp.getSignature();
		System.out.println("-----> 메소드명 : " + sig.getName());
		Object[] o = 	jp.getArgs();
		for (Object object : o) {
			System.out.println("--->인수 :: "+object);
			
		}
		
		product.setName("carami 카메라!!");
	}
	@AfterThrowing(value = "pc()", throwing = "ex" )
	public void afterThrowing(Throwable ex) {
		//메서드 호출이 예외를 던졌을 때 동작하는 어드바이스 
		System.out.println("Hello afterThrowing!  ***  메소드가 호출된 후 예외가 발생되면 실행됩니다...");
		System.out.println("exception value = " + ex.toString());
	}
	@Around("pc()")
	public Product around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("Hello around!  ***  메소드가 호출 되기 전 실행됩니다...");
		
		Signature sig = pjp.getSignature();
		System.out.println("-----> aop:: around  메소드명 : "+ sig.getName());
		
		Product p = (Product) pjp.proceed();
		
		
		System.out.println("Hello around!  ***  메소드가 호출된 후 실행됩니다...");
		
		return p;
	}

}
