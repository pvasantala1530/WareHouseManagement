package com.skillstorm.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CarInventory", schema="automobiles")
@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter
public class CarInventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_inventory_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="carmake_id", nullable=false)
	private CarMake carmake;
	
	@Column()
	private String model;
	
	@Column
	private String color;
	
	@Column()
	private int quantity;
	
	@Column()
	private int price;
	
	

	public CarInventory() {
		super();
	}

	public CarInventory(CarMake carmake, String model, String color, int quantity, int price) {
		super();
		this.carmake = carmake;
		this.model = model;
		this.color = color;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CarMake getCarmake() {
		return carmake;
	}

	public void setCarmake(CarMake carmake) {
		this.carmake = carmake;
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
		return "CarInventory [id=" + id +  ", model=" + model + ", color=" + color
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
}
