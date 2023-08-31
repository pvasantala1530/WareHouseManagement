package com.skillstorm.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.DTOs.WareHouseResponseDTO;
import com.skillstorm.mappers.WareHouseMapper;
import com.skillstorm.repositories.WareHouseRepository;

@Service
public class WareHouseServiceImpl implements WareHouseService {

	
	
	private WareHouseRepository warehouseRepository;
	private WareHouseMapper wareHouseMapper;
	
	
	@Autowired
	public WareHouseServiceImpl(WareHouseRepository warehouseRepository, WareHouseMapper wareHouseMapper) {
		this.warehouseRepository = warehouseRepository;
		this.wareHouseMapper = wareHouseMapper;
	}



	@Override
	public List<WareHouseResponseDTO> findAll() {
		
		List<WareHouseResponseDTO> respDTOList = new ArrayList<>();
		respDTOList = wareHouseMapper.wareHouseEntitytoDTOMapper(warehouseRepository.findAll());
		return respDTOList;
	}

}
