package sample.dao;

import sample.domain.Product;

public interface ProductDao {
	void addProduct(Product product);

	Product findProduct(String name);
}
