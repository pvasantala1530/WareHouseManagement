package com.skillstorm.mappers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.skillstorm.DTOs.CarMakeDTO;
import com.skillstorm.models.CarMake;

@Component
public class CarMakeDTOMapper {

	Logger logger = LoggerFactory.getLogger(getClass());

	public List<CarMakeDTO> carMakeEntitytoDTOMapper(List<CarMake> carMakeList) {

		List<CarMakeDTO> dtoList = new ArrayList<>();
		
		  for (CarMake cm : carMakeList) 
			  {
				 
				  	dtoList.add(mapEntityToDTO(cm)); 
				  	
				  }
		  
		  
		  return dtoList;
		 

	}

	public CarMakeDTO mapEntityToDTO(CarMake cm) {
		
		CarMakeDTO dto = new CarMakeDTO();

		logger.info("cm.getWarehouse().getLocation(): "+cm.getWarehouse().getLocation());
		logger.info(cm.getMake());
		dto.setMake(cm.getMake());
		dto.setMakeId(cm.getId());
		dto.setWarehouseId(cm.getWarehouse().getId());
		dto.setWarehouseLocation(cm.getWarehouse().getLocation());
		
		return dto;
	}

}
