package br.josets.foodserviceexample.controller.projections;

import java.util.LinkedList;
import java.util.List;

public class OrderProjection {

	private List<FoodProjection> items = new LinkedList<>();

	public List<FoodProjection> getItems() {
		return items;
	}

	public void setItems(List<FoodProjection> items) {
		this.items = items;
	}
	
}
