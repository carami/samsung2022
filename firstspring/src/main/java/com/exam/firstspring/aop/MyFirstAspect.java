package com.exam.firstspring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import com.exam.firstspring.domain.Todo;

public class MyFirstAspect {
	public void before(JoinPoint jp) {
		System.out.println("MyFirstAspect before~~~   메서드가 실행되기 전에 실행됩니다. ");
		Signature sig = jp.getSignature();
		System.out.println("실행되는 메서드명 : "+sig.getName());
		
	}
	
	public void after() {
		// 메서드 종료 후에 동작하는 어드바이스
		System.out.println("Hello After! *** 메서드가 호출된 후에 나옵니다!");
		}

		public void afterReturning(JoinPoint jp, Todo todo) {
			// 메서드 호출이 예외를 내보내지 않고 종료했을 때 동작하는 어드바이스
			System.out.println("Hello AfterReturning! *** 메서드가 호출된 후에 나옵니다!");
			Signature sig = jp.getSignature();
			System.out.println("-----> 메서드명：" + sig.getName());
			Object[] o = jp.getArgs();
			System.out.println("-----> 인수：" + o[0]);
		}

		public void around(ProceedingJoinPoint pjp) throws Throwable {
			// 메서드 호출 전후에 동작하는 어드바이스
			System.out.println("Hello Around! before *** 메서드가 호출되기 전에 나옵니다!");

			Signature sig = pjp.getSignature();
			System.out.println("-----> aop:around 메서드명：" + sig.getName());
			
			System.out.println("Hello Around! after *** 메서드가 호출된 후에 나옵니다!");
			
		}

		public void afterThrowing(Throwable ex) {
			// 메서드 호출이 예외를 던졌을 때 동작하는 어드바이스
			System.out.println("Hello Throwing! *** 예외가 생기면 나옵니다!");
			System.out.println("exception value = " + ex.toString());
		}

}
