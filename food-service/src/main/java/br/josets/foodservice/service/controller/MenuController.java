package br.josets.foodservice.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.tools.javac.util.List;

@RestController
public class MenuController {

	@GetMapping("/menu")
	public List<Item> menu() {
		return List.of(new Item("Rice", 5.50f));
	}
	
}
