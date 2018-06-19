package br.josets.amqplistenerexample;

public class User {
	
	private String name;
	
	private String id;
	
	private int count;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", count=" + count + "]";
	}
	
}
