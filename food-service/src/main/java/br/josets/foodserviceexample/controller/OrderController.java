package br.josets.foodserviceexample.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.josets.foodserviceexample.controller.projections.FoodProjection;
import br.josets.foodserviceexample.controller.projections.OrderProjection;
import br.josets.foodserviceexample.exceptions.NotFoundException;
import br.josets.foodserviceexample.model.Food;
import br.josets.foodserviceexample.model.ModelUtilities;
import br.josets.foodserviceexample.model.OrderItem;
import br.josets.foodserviceexample.model.ServiceUser;
import br.josets.foodserviceexample.model.UserOrder;
import br.josets.foodserviceexample.repository.FoodDAO;
import br.josets.foodserviceexample.repository.OrderDAO;
import br.josets.foodserviceexample.repository.UserDAO;

@RestController
public class OrderController {

	@Autowired
	private OrderDAO dao;
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private FoodDAO foodDao;
	
	@GetMapping("/users/{userId}/orders")
	public Set<UserOrder> listOrders(@PathVariable Long userId) {
		ServiceUser foundUser = ModelUtilities.loadUser(userDao, userId);
		return dao.findByServiceUser(foundUser); 
	}

	@PostMapping("/users/{userId}/orders")
	@ResponseStatus(HttpStatus.CREATED)
	public UserOrder createOrder(@PathVariable Long userId, @RequestBody OrderProjection sentOrder) {
		UserOrder filled = this.loadOrderItems(sentOrder, userId);
		return dao.save(filled);
	}
	
	private UserOrder loadOrderItems(OrderProjection sentOrder, Long userId) {
		ServiceUser foundUser = ModelUtilities.loadUser(userDao, userId);
		UserOrder order = new UserOrder();
		order.setServiceUser(foundUser);
		for (FoodProjection item : sentOrder.getItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(item.getCount());
			orderItem.setFood(loadItem(item.getFood()));
			order.getItems().add(orderItem);
		}
		return order;
	}

	private Food loadItem(String foodName) {
		Food found = foodDao.findByName(foodName);
		if (found == null) {
			throw new NotFoundException("Food", "name=" + foodName);
		}
		return found;
	}
	
}