package sample.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import sample.domain.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	private Map<String, Product> storage = new HashMap();

	@Override
	public void addProduct(Product product) {
		storage.put(product.getName(), product);
	}

	@Override
	public Product findProduct(String name) {
		System.out.println("findProduct 메소드 실행!!");
		if(1==1)
			throw new RuntimeException("강제오류발생!!");
		return storage.get(name);
	}

}
