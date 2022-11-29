package sample.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

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

}
