package restaurant.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import restaurant.model.Receipt;

@Repository
public class ReceiptDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public void save(Receipt receipt) {
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.persist(receipt);
		tx.commit();
	}
	
	public List<Receipt> getReceipts(){
		String queryString="SELECT  r FROM Receipt r";
		Query query=hibernateTemplate.getSessionFactory().openSession().createQuery(queryString);
		List<Receipt> receipts=query.list();
		return receipts;
	}
}
