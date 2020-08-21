package restaurant.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CustomerOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer noOfTable;
	@OneToMany(mappedBy="customerOrder",fetch = FetchType.EAGER)
	private List<ProductOrdered> order;
	private Double totalOrder;
	@ManyToOne
	private Receipt receipt;
	
	
	public Integer getNoOfTable() {
		return noOfTable;
	}
	public void setNoOfTable(Integer noOfTable) {
		this.noOfTable = noOfTable;
	}
	public Double getTotalOrder() {
		return totalOrder;
	}
	public void setTotalOrder(Double totalOrder) {
		this.totalOrder = totalOrder;
	}
	public Receipt getReceipt() {
		return receipt;
	}
	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}
	
	public Double calculateOrder(Double price, Integer quantity) {
		totalOrder=price*quantity;
		return totalOrder;
	}
	public List<ProductOrdered> getOrder() {
		return order;
	}
	public void setOrder(List<ProductOrdered> order) {
		this.order = order;
	}
	public CustomerOrder() {}
}
