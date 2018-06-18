package br.josets.foodserviceexample.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.josets.foodserviceexample.model.Food;

@RestController
public class MenuController {

	@Autowired
	private JpaRepository<Food, Long> dao;
	
	@GetMapping("/menu")
	public Set<Food> listAvailable() {
		return new HashSet<>(dao.findAll());
	}
	
	@PostMapping("/menu")
	public Food add(@RequestBody Food food) {
		return dao.save(food);
	}
	
}
