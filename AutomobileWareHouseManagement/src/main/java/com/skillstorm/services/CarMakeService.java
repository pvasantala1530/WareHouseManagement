package com.skillstorm.services;

import java.util.List;

import com.skillstorm.DTOs.CarMakeDTO;

public interface CarMakeService {

	
	List<CarMakeDTO>  findByWareHouseId(int wareHouseId);
	
	void saveNewCarMake(int Warehouseid, String newCarMake);
	
	void deleteCarMakeById(int carmakeid);
	
}
