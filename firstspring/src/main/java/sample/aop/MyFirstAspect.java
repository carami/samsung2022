package sample.aop;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import sample.domain.Product;

public class MyFirstAspect {
	public void before(JoinPoint jp) {
		//target이 실행되기 전에 동작!! 
		
		System.out.println("Hello Before!!!!   *****  메서드가 호출 되기 전에 실행됩니다^^");
		
		Signature sig = jp.getSignature();
		
		System.out.println("-------------------> 메소드 명 ::::  "+sig.getName());
		Object[] args = jp.getArgs();
		for (Object object : args) {
			System.out.println("------->  인자:::"+object);
		}		
	}
	
	public void after() {
		// 메서드 종료 후에 호출되는 메서드!!!
		System.out.println("Hello After!!!   *****  메소드 호출 후 실행됩니다.");
	}
	
	public void afterReturning(JoinPoint jp) {
		//메소드 호출이 예외를 내보내지 않고 종료했을때 동작하는 어드바이스 
		System.out.println("Hello afterReturning!!!!   *****  메서드가 호출된 후에 실행됩니다^^");
		
		Signature sig = jp.getSignature();
		
		System.out.println("-------------------> 메소드 명 ::::  "+sig.getName());
	}
	
	public void afterThrowing(Throwable ex) {
		//메소드 호출이 예외를 던졌을 때 동작하는 어드바이스!! 	
		System.out.println("Hello afterThrowing!!!    ***  예외가 발생했을 때 실행됩니다.");
		System.out.println("Exception value ::: "+ ex.toString());
	
	}
	
	public Product around(ProceedingJoinPoint pjp) throws Throwable{
		//메서도 호출 전 후에 동작하는 어드바이스 
		System.out.println("Hello Around!!!   before   ****  메서드 호출되기 전에 나옵니다!!");
		Signature sig = pjp.getSignature();
		System.out.println("----->aop:arount   메소드명!!! "+sig.getName());
		Product p =(Product)pjp.proceed();
		System.out.println("Hello Around!!!  after **** 메소드가 호출 된 후에 나옵니다!!  ");
		return p;
	}
	
	
	
}
