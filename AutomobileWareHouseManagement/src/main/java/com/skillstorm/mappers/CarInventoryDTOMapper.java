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
	
	public CarInventory carInventoryDTOtoEntityMapper(CarInventoryDTO cidto) {
		
		CarInventory ci = new CarInventory();
		ci.setColor(cidto.getColor());
		ci.setModel(cidto.getModel());
		ci.setPrice(cidto.getPrice());
		ci.setQuantity(cidto.getQuantity());
		
		
		return ci;
	}

	public CarInventoryDTO mapEntityToDTO(CarInventory ci) {

		CarInventoryDTO dto = new CarInventoryDTO();

		// logger.info("cm.getWarehouse().getLocation():
		// "+cm.getWarehouse().getLocation());
		// logger.info(cm.getMake());
		dto.setColor(ci.getColor());
		
		if(ci.getCarmake()!=null && ci.getCarmake().getId()!=0)
		dto.setcarmakeid(ci.getCarmake().getId());
		
		dto.setModel(ci.getModel());
		dto.setPrice(ci.getPrice());
		dto.setQuantity(ci.getQuantity());
		dto.setInventoryid(ci.getId());
		
		if(ci.getCarmake()!=null && ci.getCarmake().getWarehouse()!=null)
		{
			dto.setWarehouseid(ci.getCarmake().getWarehouse().getId());
			dto.setCarmake(ci.getCarmake().getMake());
		}
		

		return dto;
	}

}
