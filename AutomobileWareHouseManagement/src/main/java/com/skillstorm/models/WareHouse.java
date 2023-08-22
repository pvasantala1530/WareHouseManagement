package com.skillstorm.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="WareHouse", schema="automobiles", uniqueConstraints = { @UniqueConstraint(columnNames = { "location"}) })

public class WareHouse {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "warehouse_id")
	private int id;
	
	@Column(length = 50)
	private String location;
	
	@JsonBackReference
	@OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE) 
	List<CarMake> carMakes;
	
	@JsonBackReference
	@OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE) 
	List<MotorcycleMake> motorcycleMake;
	

	public WareHouse() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public List<CarMake> getCarMakes() {
		return carMakes;
	}


	public void setCarMakes(List<CarMake> carMakes) {
		this.carMakes = carMakes;
	}


	public List<MotorcycleMake> getMotorcycleMake() {
		return motorcycleMake;
	}


	public void setMotorcycleMake(List<MotorcycleMake> motorcycleMake) {
		this.motorcycleMake = motorcycleMake;
	}


	@Override
	public String toString() {
		return "WareHouse [id=" + id + ", location=" + location + ", carMakes=" + carMakes + ", motorcycleMake="
				+ motorcycleMake + "]";
	}



	
}
