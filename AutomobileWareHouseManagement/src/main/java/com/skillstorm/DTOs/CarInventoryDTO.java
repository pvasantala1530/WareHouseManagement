package com.skillstorm.DTOs;

public class CarInventoryDTO {
	
	private int carmakeid;
	
	private String model;
	
	private String color;
	
	private int quantity;
	
	private int price;

	public CarInventoryDTO() {
		super();
	}

	public int getcarmakeid() {
		return carmakeid;
	}

	public void setcarmakeid(int carmakeid) {
		this.carmakeid = carmakeid;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CarInventoryDTO [carmakeid=" + carmakeid + ", model=" + model + ", color=" + color + ", quantity="
				+ quantity + ", price=" + price + "]";
	}
	

}
