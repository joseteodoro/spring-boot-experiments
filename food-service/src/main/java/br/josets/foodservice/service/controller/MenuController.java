package br.josets.foodservice.service.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
	
	Set<Item> items = Stream.of(new Item("Rice", 5.50f))
	         .collect(Collectors.toCollection(HashSet::new));
	
	@GetMapping("/menu")
	public Set<Item> menu() {
		return items;
	}
	
	@PostMapping("/menu")
	public Item addMenuItem(@RequestBody Item item) {
		this.items.add(item);
		return item;
	}
	
}
