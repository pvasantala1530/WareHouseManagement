package com.skillstorm.models;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@ManyToOne
	@JoinColumn(name="carmake_id", nullable=false)
	private BikeMake carmake;
	
	@Column()
	private String model;
	
	@Column()
	private int quantity;
	
	@Column()
	private int price;
	
	
}
