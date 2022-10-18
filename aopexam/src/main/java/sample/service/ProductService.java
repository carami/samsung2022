package sample.service;

import sample.domain.Product;

public interface ProductService {
	void addProduct(Product product);
	Product findByProductName(String name);
}
