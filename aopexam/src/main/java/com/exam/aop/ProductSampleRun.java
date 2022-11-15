package com.exam.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.domain.Product;
import com.sample.service.ProductService;

public class ProductSampleRun {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ProductService service = context.getBean(ProductService.class);
		
		service.addProduct(new Product("카메라", 2000000));
		
		System.out.println(service.findByProductName("카메라"));
	}

}
