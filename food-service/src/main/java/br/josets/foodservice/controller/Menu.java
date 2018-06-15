package br.josets.foodservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.josets.foodservice.model.Item;

@RestController
public class Menu {

	@RequestMapping("/menu")
	public List<Item> menu() {
		return List.of(new Item("Rice", 3.f), new Item("Beans", 2f), new Item("Meat", 10f));
	}
	
}
