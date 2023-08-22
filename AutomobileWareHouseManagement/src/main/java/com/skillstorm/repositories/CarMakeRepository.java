package com.skillstorm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.CarMake;

@Repository
public interface CarMakeRepository extends JpaRepository<CarMake, Integer>{
	
	//@Query("SELECT cm FROM CarMake cm WHERE cm.warehouse.id = ?1")
	//public List<CarMake> findcarMakeByWarehouseId(int id);
	
	public List<CarMake> findByWarehouseId(int id);
	

}
