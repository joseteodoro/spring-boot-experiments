package br.josets.foodservice.model;

public class Item {

	private String name;

	private Float price;
	
	Item() {
		this.name = "";
		this.price = 0f;
	}
	
	public Item(String name, Float price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

}
