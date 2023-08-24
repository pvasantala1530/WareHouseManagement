package com.skillstorm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.CarInventory;

@Repository
public interface CarInventoryRepository extends JpaRepository<CarInventory, Integer>{

	public List<CarInventory> findByCarmakeId(int id);
	
	public int countByCarMakeId(int carmakeid);
	
}
