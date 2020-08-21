package restaurant.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import restaurant.model.CustomerOrder;
import restaurant.model.ProductOrdered;

@Repository
public class CustomerOrderDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public void save(CustomerOrder customerOrder) {
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(customerOrder);
		tx.commit();
		session.close();
	}
	
	public List<CustomerOrder> getOrdersUnpaid(){
		Query query=hibernateTemplate.getSessionFactory().openSession().createQuery("SELECT c FROM CustomerOrder c WHERE c.receipt is null");
		List<CustomerOrder> ordersUnpaid=query.list();
		return ordersUnpaid;
	}
	
	public CustomerOrder getExistingCustomerOrder(Integer table) {
		String getStatusOrder="SELECT o from CustomerOrder o WHERE o.receipt IS NULL AND o.noOfTable=:table";
		List<CustomerOrder> getOrder=(List<CustomerOrder>) hibernateTemplate.findByNamedParam(getStatusOrder, "table",table);
		if(getOrder.size()>0) {
			return getOrder.get(0);
		}else {
			return null;
		}
	}
}
