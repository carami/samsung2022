package com.sample.dao;

import com.sample.domain.Product;

public interface ProductDao {
	void addProduct(Product product);
	Product findProduct(String name);
}
