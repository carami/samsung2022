package sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.domain.Product;
import sample.service.ProductService;

public class ProductRun {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("sample/config/applicationContext.xml");
		
		ProductService service = context.getBean(ProductService.class);
		
		service.addProduct(new Product("pen", 2000));
		
		Product product = 	service.findByProductName("pen");
		
		System.out.println(product);
	}

}
