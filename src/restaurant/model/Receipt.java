package restaurant.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Receipt {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Double total;
	@OneToMany(mappedBy="receipt")
	private List<CustomerOrder> orders;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date=new Date();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public List<CustomerOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<CustomerOrder> orders) {
		this.orders = orders;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
