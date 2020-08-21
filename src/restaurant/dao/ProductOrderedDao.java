package restaurant.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import restaurant.model.ProductOrdered;

@Repository
public class ProductOrderedDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public void save(ProductOrdered product) {
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.persist(product);
		tx.commit();
	
	}
	
	public List<ProductOrdered> productsOrderedByTableNo(Integer table){
		String selectQuery="SELECT p FROM ProductOrdered p, CustomerOrder co WHERE co.id=p.customerOrder.id AND co.noOfTable=:noOfTable AND co.receipt IS NULL";
		List<ProductOrdered> productsOrdered=(List<ProductOrdered>) hibernateTemplate.findByNamedParam(selectQuery, "noOfTable", table);
		return productsOrdered;
	}
}
