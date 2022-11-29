package sample.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import sample.domain.Product;

public class MyFirstAspect {
	public void before(JoinPoint jp) {
		//메소드가 시작 되기 전에 동작하는 어드바이스!!  
		System.out.println("Hello Before!!!    *****   메소드가 호출되기 전에 실행됩니다. ");
		Signature sig =	jp.getSignature();
		System.out.println("--------> 메소드 명 ::" + sig.getName());
		Object[] args =	jp.getArgs();
		
		for (Object object : args) {
			System.out.println("-------->인자:::"+object);
		}
	}
	
	public void after() {
		System.out.println("Hello After!!  ****  메소드가 호출 된 후에 실행!! ");
	}
	
	public void afterReturning(JoinPoint jp,Product product) {
		System.out.println("Hello afterReturning!!!    *****   메소드가 예외없이 실행이 종료되었을 때 실행됩니다. ");
		Signature sig =	jp.getSignature();
		System.out.println("--------> 메소드 명 ::" + sig.getName());
		Object[] args =	jp.getArgs();
		
		for (Object object : args) {
			System.out.println("-------->인자:::"+object);
		}
		product.setName("pen222");
	}
	
	public void afterThrowing(Throwable ex) {
		System.out.println("Hello afterThrowing!  ***    예외가 발생되었을 때 실행됨. ");
		System.out.println("exception value = "+ ex.toString());
	}
	
	public Product around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("Hello around!!!    *****   before 가 샐행된 후 실행  ");
		Signature sig =	pjp.getSignature();
		System.out.println("--------> 메소드 명 ::" + sig.getName());
		
		Product product = (Product)pjp.proceed();
		
		System.out.println("Hello around!!!    *****   after 가 실행되기 전 실행  ");
		product.setPrice(50000);
		return product;
	}

}
