package restaurant.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

public enum MenuList {

	FRENCH_FRIES(10.00),
	STEAK(15.00),
	PASTA(20.00),
	PIZZA_CHEESE_S(24.00),
	PIZZA_CHEESE_M(29.00), 
	KEBAB(24.00),
	BEEF(15.00),
	SOUCE(5.00);
	
	private Double price;
	private MenuList(Double price) {
		this.price=price;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Transient
	private static List<MenuList> arrList=Arrays.asList(MenuList.values());
	
	@ManyToOne
	CustomerOrder customerOrder;
	
	public static Map<MenuList, Double> getMenuList() {
		Map<MenuList, Double> menuList=new HashMap<MenuList, Double>();
		for(MenuList product:arrList) {
			menuList.put(product, product.getPrice());
		}
		return menuList;
	}
}
