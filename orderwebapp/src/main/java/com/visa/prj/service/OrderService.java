package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.OrderDao;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.entity.Item;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;

@Service

public class OrderService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderDao orderDao;
	
	public List<Order> getOrders() {
		return orderDao.getOrders();
	}
	
	@Transactional
	public void executeOrder(Order o) {
		orderDao.placeOrder(o); // stores in orders and items table because of "Cascade"
		List<Item> items = o.getItems();
		double total = 0.0;
		for(Item i : items) {
			total += i.getAmount();
			Product p = productDao.getProduct(i.getProduct().getId());
			p.setCount(p.getCount() - i.getQty()); // Dirty Checking
		}
		o.setTotal(total);
	}
	
	@Transactional
	public void addProduct(Product p) {
		productDao.addProduct(p);
	}
	
	public List<Product> getProducts() {
		return productDao.getProducts();
	}
	
	public Product getProduct(int id) {
		return productDao.getProduct(id);
	}
}
