package com.sample.aop;

import org.aspectj.lang.JoinPoint;

public class MyFirstAspect {
	public void before(JoinPoint jp) {
		System.out.println("Hello Before!!!   ******   메소드가 호출되기 전에 실행됩니다!!");
	}

}
