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
@Table(name="MotorcycleInventory", schema="automobiles")
@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter
public class MotorcycleInventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "motorcycle_inventory_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="motorcyclemake_id", nullable=false)
	private MotorcycleMake motorcyclemake;
	
	@Column()
	private String model;
	
	@Column
	private String color;
	
	@Column()
	private int quantity;
	
	@Column()
	private int price;

	public MotorcycleInventory(MotorcycleMake motorcyclemake, String model, String color, int quantity, int price) {
		super();
		this.motorcyclemake = motorcyclemake;
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

	public MotorcycleMake getMotorcyclemake() {
		return motorcyclemake;
	}

	public void setMotorcyclemake(MotorcycleMake motorcyclemake) {
		this.motorcyclemake = motorcyclemake;
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
	
	

	
	
}
