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
@Table(name="CarSpareParts", schema="automobiles")
@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter
public class CarSpareParts {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_sparepart_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="warehouse_id")
	private WareHouse wareHouse;
	
	@Column()
	private String name;
	
	@Column()
	private int quantity;
	
	@Column()
	private int price;

	
}
