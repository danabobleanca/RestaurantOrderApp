package restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant.dao.ProductOrderedDao;
import restaurant.model.ProductOrdered;

@Service
public class ProductOrderedService {
	@Autowired
	ProductOrderedDao productOrderedDao;

	public void save(ProductOrdered product) {
		productOrderedDao.save(product);
	}
	
	public List<ProductOrdered> productsOrderedByTableNo(Integer table){
		return productOrderedDao.productsOrderedByTableNo(table);
	}
}
