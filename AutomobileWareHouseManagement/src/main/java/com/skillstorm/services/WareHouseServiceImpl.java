package com.skillstorm.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.DTOs.WareHouseResponseDTO;
import com.skillstorm.mappers.WareHouseMapper;
import com.skillstorm.repositories.WareHouseRepository;

@Service
public class WareHouseServiceImpl implements WareHouseService {

	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	private WareHouseRepository warehouseRepository;
	private WareHouseMapper wareHouseMapper;
	
	
	@Autowired
	public WareHouseServiceImpl(WareHouseRepository warehouseRepository, WareHouseMapper wareHouseMapper) {
		this.warehouseRepository = warehouseRepository;
		this.wareHouseMapper = wareHouseMapper;
	}


	/*
	 * This method gets the list of warehouses from the warehouses table
	 * */
	@Override
	public List<WareHouseResponseDTO> findAll() {
		
		List<WareHouseResponseDTO> respDTOList = new ArrayList<>();
		
		respDTOList = wareHouseMapper.wareHouseEntitytoDTOMapper(warehouseRepository.findAll());
		
		logger.debug("Warewhouses list: "+respDTOList);
		
		return respDTOList;
	}

}
