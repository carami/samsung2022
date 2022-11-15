package com.sample.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sample.domain.Product;
@Repository
public class ProductDaoImpl implements ProductDao {
	private Map<String,Product> storage = new HashMap<String,Product>();

	@Override
	public void addProduct(Product product) {
		 storage.put(product.getName(), product);

	}

	@Override
	public Product findProduct(String name) {
		return storage.get(name);
	}

}
