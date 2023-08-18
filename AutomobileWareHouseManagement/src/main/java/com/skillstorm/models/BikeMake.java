package com.skillstorm.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="BikeMake", schema="automobiles")
@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter
public class BikeMake {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bike_make_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="warehouse_id", nullable=false)
	private WareHouse warehouse;
	
	@Column(length = 50)
	private String make;
	
	@JsonBackReference
	@OneToMany(mappedBy = "bikemake", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE) 
	List<BikeInventory> bikeinventory;
	
	
}
