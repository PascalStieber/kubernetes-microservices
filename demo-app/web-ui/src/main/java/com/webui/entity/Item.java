package com.webui.entity;

import org.springframework.data.annotation.Id;

public class Item {

	@Id
	private String id;
	private String name = "";
	private String description = "";
	private double price = 0.00;
	private int number;
	private boolean instock = true;

	public Item() {}
	
	public Item(String pName, String pDescription, double pPrice, int pNumber, boolean pInStock) {
		this.name = pName;
		this.description = pDescription;
		this.price = pPrice;
		this.number = pNumber;
		this.setInstock(pInStock);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isInstock() {
		return instock;
	}

	public void setInstock(boolean instock) {
		this.instock = instock;
	}

}
