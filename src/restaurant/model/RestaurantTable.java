package restaurant.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class RestaurantTable {
	@Id
	private Integer tableNumber;
	private Integer numberOSeats;
	@Transient
	private Integer totalNumberOfSeats;
	/*@OneToMany(mappedBy="table")
	private List<CustomerOrder> orders;*/

	/*public List<CustomerOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<CustomerOrder> orders) {
		this.orders = orders;
	}*/
	public Integer getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(Integer tableNumber) {
		this.tableNumber = tableNumber;
	}
	public Integer getNumberOSeats() {
		return numberOSeats;
	}
	public void setNumberOSeats(Integer numberOSeats) {
		this.numberOSeats = numberOSeats;
	}
	/*public Integer getTotalNumberOfSeats() {
		return totalNumberOfSeats;
	}
	public void setTotalNumberOfSeats(Integer totalNumberOfSeats) {
		this.totalNumberOfSeats = totalNumberOfSeats;
	}*/
}
