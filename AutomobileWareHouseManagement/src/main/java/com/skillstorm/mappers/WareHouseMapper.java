package com.skillstorm.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.skillstorm.DTOs.WareHouseResponseDTO;
import com.skillstorm.models.WareHouse;
import com.skillstorm.repositories.WareHouseRepository;



@Component
public class WareHouseMapper {
	
	Logger logger = LoggerFactory.getLogger(getClass()); 
	
	/*
	 * private WareHouseRepository wareHouseRepository;
	 * 
	 * public WareHouseMapper(WareHouseRepository wareHouseRepository) {
	 * this.wareHouseRepository = wareHouseRepository; }
	 */

	/*
	 * public List<WareHouseResponseDTO> wareHouseEntitytoDTOMapper1() {
	 * 
	 * return wareHouseRepository.findAll() .stream() .map(this::mapEntityToDTO)
	 * .collect(Collectors.toList());
	 * 
	 * 
	 * }
	 */
	  
 public List<WareHouseResponseDTO> wareHouseEntitytoDTOMapper(List<WareHouse> warehouseList) { 
		  
			  List<WareHouseResponseDTO> dtoList = new ArrayList<>();
			  
			  for(WareHouse wareHouse: warehouseList) 
				  dtoList.add(mapEntityToDTO(wareHouse));
			
				  return dtoList;
			 
	  
	  }
	 
	 
	
	public WareHouseResponseDTO mapEntityToDTO(WareHouse warehouse)
	{
		WareHouseResponseDTO wareHouseResponseDTO=new WareHouseResponseDTO();
		
		wareHouseResponseDTO.setId(warehouse.getId());
		wareHouseResponseDTO.setLocation(warehouse.getLocation());
		
		return wareHouseResponseDTO;
	}
}
