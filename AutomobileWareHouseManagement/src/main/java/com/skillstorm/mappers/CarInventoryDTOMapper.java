package com.skillstorm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.skillstorm.DTOs.CarInventoryDTO;
import com.skillstorm.models.CarInventory;

@Component
public class CarInventoryDTOMapper {

	Logger logger = LoggerFactory.getLogger(getClass());

	public List<CarInventoryDTO> carInventoryEntitytoDTOMapper(List<CarInventory> carInventoryList) {

		List<CarInventoryDTO> dtoList = new ArrayList<>();

		for (CarInventory ci : carInventoryList) {

			dtoList.add(mapEntityToDTO(ci));

		}

		return dtoList;

	}

	public CarInventoryDTO mapEntityToDTO(CarInventory ci) {

		CarInventoryDTO dto = new CarInventoryDTO();

		// logger.info("cm.getWarehouse().getLocation():
		// "+cm.getWarehouse().getLocation());
		// logger.info(cm.getMake());
		dto.setColor(ci.getColor());
		dto.setInventoryid(ci.getId());
		dto.setModel(ci.getModel());
		dto.setPrice(ci.getPrice());
		dto.setQuantity(ci.getQuantity());

		return dto;
	}

}
