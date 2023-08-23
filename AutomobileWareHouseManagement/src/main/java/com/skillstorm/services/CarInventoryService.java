package com.skillstorm.services;

import java.util.List;

import com.skillstorm.DTOs.CarInventoryDTO;

public interface CarInventoryService {
	
public 	List<CarInventoryDTO> findCarInventoryBymakeId(int carmakeid);	

}
