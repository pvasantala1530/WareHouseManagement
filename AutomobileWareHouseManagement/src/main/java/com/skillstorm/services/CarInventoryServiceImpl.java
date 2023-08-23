package com.skillstorm.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.DTOs.CarInventoryDTO;
import com.skillstorm.DTOs.CarMakeDTO;
import com.skillstorm.mappers.CarInventoryDTOMapper;
import com.skillstorm.repositories.CarInventoryRepository;

@Service
public class CarInventoryServiceImpl implements CarInventoryService {

	
	private CarInventoryRepository carInventoryRepository;
	private CarInventoryDTOMapper carInventoryDTOMapper;
	
	
	@Autowired
	public CarInventoryServiceImpl(CarInventoryRepository carInventoryRepository,
			CarInventoryDTOMapper carInventoryDTOMapper) {
		super();
		this.carInventoryRepository = carInventoryRepository;
		this.carInventoryDTOMapper = carInventoryDTOMapper;
	}



	@Override
	public List<CarInventoryDTO> findCarInventoryBymakeId(int carmakeid) {


		
		
		List<CarInventoryDTO>  dtolist = new ArrayList<>();
		dtolist = carInventoryDTOMapper.carInventoryEntitytoDTOMapper(carInventoryRepository.findByCarmakeId(carmakeid));
		
		return dtolist;
	
		
	}

}
