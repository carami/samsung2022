package sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sample.config.AppConfig;
import sample.domain.Product;
import sample.service.ProductService;

public class ProductSampleRunJAVA {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ProductService service = context.getBean(ProductService.class);
		
		service.addProduct(new Product("pen", 2000));
		
		Product product = service.findByProductName("pen");
		System.out.println(product);
	}

}
