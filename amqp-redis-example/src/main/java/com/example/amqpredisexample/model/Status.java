package com.example.amqpredisexample.model;

import java.io.Serializable;

public class Status implements Serializable{

	private static final long serialVersionUID = -365917800172368641L;

	private String status = "";
	
	private int count;
	
	public Status() {}

	public Status(String status, int count) {
		this.status = status;
		this.count = count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int cound) {
		this.count = cound;
	}
	
	public void inc() {
		this.count++;
	}
	
}
