package com.skillstorm.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skillstorm.DTOs.WareHouseResponseDTO;
import com.skillstorm.models.WareHouse;

@Component
public class WareHouseMapper {
	
	@Autowired
	private WareHouseResponseDTO wareHouseResponseDTO;
	
	public WareHouseResponseDTO wareHouseEntitytoDTOMapper(WareHouse warehouse)
	{
		wareHouseResponseDTO.s
		return wareHouseResponseDTO;
	}
}
