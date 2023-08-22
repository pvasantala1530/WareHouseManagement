package com.skillstorm.services;

import java.util.List;

import com.skillstorm.DTOs.WareHouseResponseDTO;

public interface WareHouseService {
	
	List<WareHouseResponseDTO> findAll(); 

}
