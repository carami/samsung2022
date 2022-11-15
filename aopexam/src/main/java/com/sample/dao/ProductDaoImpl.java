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
		System.out.println("ProductDAO ----  findProduct() 실행!!");
		
//		if(1 == 1)
//			throw new RuntimeException("강제 오류 발생!!!!");
		return storage.get(name);
	}

}
