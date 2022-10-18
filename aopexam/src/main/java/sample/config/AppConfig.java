package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import sample.aop.MyFirstAspect;
import sample.dao.ProductDao;
import sample.dao.ProductDaoImpl;
import sample.service.ProductService;
import sample.service.ProductServiceImpl;
//
//@Configuration
//@EnableAspectJAutoProxy //반드시 있어야지만 aop 가 동작한다.
public class AppConfig {
	@Bean
	public ProductDao productDao() {
		return new ProductDaoImpl();
	}

	@Bean
	public ProductService productService() {
		return new ProductServiceImpl();
	}
	
	@Bean
	public MyFirstAspect myFirstAspect() {
		return new MyFirstAspect();
	}
}
