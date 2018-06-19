package com.example.amqpredisexample.model;

import java.util.Date;

public class AskForFood {
	
	private Long id;
	
	private Long date;
	
	private String foodName;
	
	private String Status;

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AskForFood [id=" + id + ", date=" + new Date(date) + ", foodName=" + foodName + ", Status=" + Status + "]";
	}

	
}
