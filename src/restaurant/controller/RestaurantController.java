package restaurant.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import restaurant.model.CustomerOrder;
import restaurant.model.MenuList;
import restaurant.model.ProductOrdered;
import restaurant.model.Receipt;
import restaurant.service.CustomerOrderService;
import restaurant.service.ProductOrderedService;
import restaurant.service.ReceiptService;
@Controller
public class RestaurantController {
	//MenuList menu;
	//CustomerOrder customer=new CustomerOrder();
	Map<MenuList, Double> menuList=MenuList.getMenuList();
	ProductOrdered product=null;
	
	@Autowired
	ProductOrderedService productOrderedService;
	@Autowired
	CustomerOrderService customerOrderService;
	@Autowired
	ReceiptService receiptService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView welcome(ModelAndView mv) {
		mv.addObject("menuItems", menuList);
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value="/continueOrder", method=RequestMethod.POST)
	public ModelAndView registerOrder(ModelAndView mv, @RequestParam("menu") String[] items, HttpSession session) {
		Map<MenuList, Double> orderList=new HashMap<MenuList, Double>();
		session.setAttribute("orderList", orderList);
		for(int i=0;i<items.length;i++) {
			MenuList menu=MenuList.valueOf(items[i]);
			if(menuList.containsKey(menu)) {
				//MenuList menu=MenuList.valueOf(items[i]);
				orderList.put(menu, menu.getPrice());
			}
		}
		mv.addObject("items", orderList);
		mv.setViewName("continueOrder");
		return mv;
	}
	
	@RequestMapping(value="/registeredOrder", method=RequestMethod.POST)
	public ModelAndView orderRegistered(ModelAndView mv, HttpServletRequest request, HttpSession session) {
		Map<MenuList, Double> orderList=(Map<MenuList, Double>) session.getAttribute("orderList");
		Integer noOfTable=Integer.parseInt(request.getParameter("table"));
		CustomerOrder order=new CustomerOrder();
		CustomerOrder existingOrder=customerOrderService.getExistingCustomerOrder(noOfTable);
		List<ProductOrdered> productsOrdered=new ArrayList<ProductOrdered>();
		session.setAttribute("order", order);
		//session.setAttribute("products", allOrderProducts);
		Double totalOrder=0.00;
		Double totalExistingOrder=0.00;
		Double totalCurrentOrder=0.00;
		//Set set=(Set)orderList.entrySet();
		//Iterator it=set.iterator();
		if(existingOrder==null) {
			order.setNoOfTable(noOfTable);
			customerOrderService.save(order);
		}
		for(Entry<MenuList, Double> entry:orderList.entrySet()){
			String item=request.getParameter(entry.getKey().toString());
			Integer quantity=Integer.parseInt(item);
			 product=new ProductOrdered(entry.getKey(), entry.getValue(),quantity);
			 productsOrdered.add(product);
			totalCurrentOrder+=order.calculateOrder(entry.getValue(), quantity);
			if(existingOrder!=null) {
				order=existingOrder;
				/*List<ProductOrdered> products=order.getOrder();
				for(ProductOrdered p:products) {
					allOrderProducts.add(p);
				}*/
				totalExistingOrder=order.getTotalOrder();
				product.setCustomerOrder(order);
			}else {
				product.setCustomerOrder(order);
				totalExistingOrder=0.00;
			}
			productOrderedService.save(product);
		}
		
		totalOrder+=totalExistingOrder+totalCurrentOrder;
		order.setTotalOrder(totalOrder);
		order.setOrder(productsOrdered);
		customerOrderService.save(order);
		
		mv.addObject("currentOrder", totalCurrentOrder);
		mv.addObject("listProducts",productsOrdered);
		mv.setViewName("orderRegistered");
		return mv;
	}
	
	@RequestMapping(value="/ordersUnpaid",method=RequestMethod.GET)
	public ModelAndView unpaidOrder(ModelAndView mv) {
		mv.setViewName("ordersUnpaid");
		List<CustomerOrder> ordersUnpaid=customerOrderService.getOrdersUnpaid();
		mv.addObject("ordersUnpaid", ordersUnpaid);
		return mv;
	}
	
	@RequestMapping(value="/payOrder",method=RequestMethod.GET )
	public ModelAndView payOrder(ModelAndView mv, HttpSession session, @RequestParam("noOfTable") Integer noOfTable) {
		CustomerOrder orderToPay=customerOrderService.getExistingCustomerOrder(noOfTable);
		session.setAttribute("payOrder", orderToPay);
		List<ProductOrdered> products=(List<ProductOrdered>)orderToPay.getOrder();
		//List<ProductOrdered> products=order.getOrder();
		mv.addObject("products", products);
		mv.setViewName("payOrder");
		return mv;
	}
	
	@RequestMapping(value="/receiptRegister", method=RequestMethod.POST)
	public ModelAndView receiptRegistere(ModelAndView mv, HttpSession session) {
		mv.setViewName("receiptRegistered");
		Receipt receipt=new Receipt();
		CustomerOrder order=(CustomerOrder) session.getAttribute("payOrder");
		receipt.setTotal(order.getTotalOrder());
		//receipt.setDate(new Date());
		receiptService.save(receipt);
		order.setReceipt(receipt);
		customerOrderService.save(order);
		return mv;
	}
	
	@RequestMapping(value="/gotomenu",method=RequestMethod.GET )
	public String goToMenu(ModelAndView mv) {
		return "redirect:/";
	}
	
	@RequestMapping(value="/receipts", method=RequestMethod.GET)
	public ModelAndView receipts(ModelAndView mv) {
		List<Receipt> receipts=receiptService.getReceipts();
		mv.addObject("receipts", receipts);
		mv.setViewName("receipts");
		return mv;
	}
	
}
