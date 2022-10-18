package sample.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import sample.domain.Product;

@Aspect
@Component
public class MyFirstAspect {
	public MyFirstAspect() {
		System.out.println("myFirst aspect!!");
	}

	@Before("execution(* sample.dao..*(..))")
	public void before(JoinPoint jp) {
		// 메서드 시작 시에 동작하는 어드바이스
		System.out.println("Hello Before! *** 메서드가 호출되기 전에 나옵니다!");
		Signature sig = jp.getSignature();
		System.out.println("-----> 메서드명：" + sig.getName());
		Object[] o = jp.getArgs();
		System.out.println("-----> 인수：" + o[0]);
	}

	@After("execution(* findProduct(String))")
	public void after() {
		// 메서드 종료 후에 동작하는 어드바이스
		System.out.println("Hello After! *** 메서드가 호출된 후에 나옵니다!");
	}

	@AfterReturning(value = "execution(* findProduct(String))", returning = "product")
	public void afterReturning(JoinPoint jp, Product product) {
		// 메서드 호출이 예외를 내보내지 않고 종료했을 때 동작하는 어드바이스
		System.out.println("Hello AfterReturning! *** 메서드가 호출된 후에 나옵니다!");
		Signature sig = jp.getSignature();
		System.out.println("-----> 메서드명：" + sig.getName());
		Object[] o = jp.getArgs();
		System.out.println("-----> 인수：" + o[0]);
	}

	@Around("execution(* findProduct(String))")
	public Product around(ProceedingJoinPoint pjp) throws Throwable {
		// 메서드 호출 전후에 동작하는 어드바이스
		System.out.println("Hello Around! before *** 메서드가 호출되기 전에 나옵니다!");

		Signature sig = pjp.getSignature();
		System.out.println("-----> aop:around 메서드명：" + sig.getName());
		Product p = (Product) pjp.proceed();
		System.out.println("Hello Around! after *** 메서드가 호출된 후에 나옵니다!");
		return p;
	}

	@AfterThrowing(value = "execution(* findProduct(String))", throwing = "ex")
	public void afterThrowing(Throwable ex) {
		// 메서드 호출이 예외를 던졌을 때 동작하는 어드바이스
		System.out.println("Hello Throwing! *** 예외가 생기면 나옵니다!");
		System.out.println("exception value = " + ex.toString());
	}
}