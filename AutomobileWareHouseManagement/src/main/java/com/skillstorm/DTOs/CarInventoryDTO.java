package com.skillstorm.DTOs;

public class CarInventoryDTO {
	
	private int inventoryid;
	
	private int carmakeid;
	
	private String model;
	
	private String color;
	
	private int quantity;
	
	private int price;
	
	private int warehouseid;

	public int getWarehouseid() {
		return warehouseid;
	}

	public void setWarehouseid(int warehouseid) {
		this.warehouseid = warehouseid;
	}

	public CarInventoryDTO() {
		super();
	}

	public int getInventoryid() {
		return inventoryid;
	}

	public void setInventoryid(int inventoryid) {
		this.inventoryid = inventoryid;
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
