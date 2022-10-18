package sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.domain.Product;
import sample.service.ProductService;

public class ProductSampleRun {

	public static void main(String[] args) {
//		ApplicationContext ctx = new  AnnotationConfigApplicationContext(AppConfig.class);
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ProductService productServic = ctx.getBean(ProductService.class);
		
		productServic.addProduct(new Product("핸드폰", 10000));
		
		Product product = productServic.findByProductName("핸드폰");
		
		productServic.addProduct(new Product("test", 200));
		
	}

}
