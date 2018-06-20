package br.josets.foodserviceexample.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.josets.foodserviceexample.model.Food;
import br.josets.foodserviceexample.model.ModelUtilities;
import br.josets.foodserviceexample.repository.FoodDAO;

@RestController
public class MenuController {

	@Autowired
	private FoodDAO dao;
	
	@GetMapping("/menu")
	public Set<Food> listAvailable() {
		return new HashSet<>(dao.findAll());
	}
	
	@PostMapping("/menu")
	@ResponseStatus(HttpStatus.CREATED)
	public Food add(@RequestBody Food food) {
		return dao.save(food);
	}
	
	@GetMapping("/menu/{foodName}")
	public Food get(@PathVariable(name="foodName") String foodName) {
		return ModelUtilities.loadFood(dao, foodName);
	}
	
}
