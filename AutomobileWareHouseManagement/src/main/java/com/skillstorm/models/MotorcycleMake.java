package com.skillstorm.models;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="MotorcycleMake", schema="automobiles")
@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter
public class MotorcycleMake {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="motorcycle_make_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="warehouse_id", nullable=false)
	@JsonIgnore
	@JsonBackReference
	private WareHouse warehouse;
	
	@Column(length = 50)
	private String make;
	
	@JsonBackReference
	@OneToMany(mappedBy = "motorcyclemake", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE) 
	List<MotorcycleInventory> motorcycleinventory;
	
	
	

	public MotorcycleMake() {
		super();
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public WareHouse getWarehouse() {
		return warehouse;
	}




	public void setWarehouse(WareHouse warehouse) {
		this.warehouse = warehouse;
	}




	public String getMake() {
		return make;
	}




	public void setMake(String make) {
		this.make = make;
	}




	public List<MotorcycleInventory> getMotorcycleinventory() {
		return motorcycleinventory;
	}




	public void setMotorcycleinventory(List<MotorcycleInventory> motorcycleinventory) {
		this.motorcycleinventory = motorcycleinventory;
	}

	
}
