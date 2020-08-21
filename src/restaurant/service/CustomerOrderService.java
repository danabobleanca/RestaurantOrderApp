package restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant.dao.CustomerOrderDao;
import restaurant.model.CustomerOrder;

@Service
public class CustomerOrderService {

	@Autowired
	CustomerOrderDao customerOrderDao;

	public void save(CustomerOrder products) {
		customerOrderDao.save(products);
	}
	
	public List<CustomerOrder> getOrdersUnpaid(){
		 return customerOrderDao.getOrdersUnpaid();
	}
	
	public CustomerOrder getExistingCustomerOrder(Integer table) {
		return customerOrderDao.getExistingCustomerOrder(table);
	}
}
