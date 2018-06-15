package br.josets.foodservice.service.controller;

public class Item {

	private String meal;
	
	private Float price;

	public Item(String meal, Float price) {
		this.meal = meal;
		this.price = price;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

}
