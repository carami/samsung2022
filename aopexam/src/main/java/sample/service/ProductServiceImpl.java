package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.dao.ProductDao;
import sample.domain.Product;


public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	public void addProduct(Product product) {
		System.out.println("addProduct 실행");
		productDao.addProduct(product);
	}

	public Product findByProductName(String name) {
		return productDao.findProduct(name);
	}
}