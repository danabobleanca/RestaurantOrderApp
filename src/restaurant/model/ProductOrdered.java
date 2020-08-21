package restaurant.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProductOrdered {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Enumerated(EnumType.STRING)
	private MenuList product;
	private Double price;
	private Integer quantity;
	@ManyToOne
	private CustomerOrder customerOrder;

	public ProductOrdered() {}
	public ProductOrdered(MenuList product, Double price, Integer quantity) {
		super();
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		//this.customerOrder = customerOrder;
	}
	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}
	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
	public MenuList getProduct() {
		return product;
	}
	public void setProduct(MenuList product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
