package com.skillstorm.services;

import java.util.List;

import com.skillstorm.DTOs.CarInventoryDTO;
import com.skillstorm.models.CarInventory;

public interface CarInventoryService {
	
 	List<CarInventoryDTO> findCarInventoryBymakeId(int carmakeid);	

 	int saveCarInventory(CarInventoryDTO cidto);
 	
 	CarInventory getCarInventory(int inventoryid);
 	
 	int updateCarInventory(CarInventory ci,String inventoryid, String carmakeid);
 	
 	void deleteCarInventoryById(int inventoryid);
 	
 	

}
