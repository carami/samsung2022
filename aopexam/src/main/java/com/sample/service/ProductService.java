package com.sample.service;

import com.sample.domain.Product;

public interface ProductService {
	void addProduct(Product product);
	Product findByProductName(String name);
}
