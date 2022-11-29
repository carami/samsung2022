package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.dao.ProductDao;
import sample.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	@Override
	public Product findByProductName(String name) {
		return productDao.findProduct(name);
	}

}
