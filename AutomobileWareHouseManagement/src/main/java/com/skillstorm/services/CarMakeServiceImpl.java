package com.skillstorm.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.DTOs.CarMakeDTO;
import com.skillstorm.mappers.CarMakeDTOMapper;
import com.skillstorm.repositories.CarMakeRepository;

@Service
public class CarMakeServiceImpl implements CarMakeService {

	private CarMakeRepository carmakeRepo;
	private CarMakeDTOMapper mapper;
	
	
	@Autowired
	public CarMakeServiceImpl(CarMakeRepository carmakeRepo, CarMakeDTOMapper mapper) {
		super();
		this.carmakeRepo = carmakeRepo;
		this.mapper = mapper;
	}



	@Override
	public List<CarMakeDTO>  findByWareHouseId(int wareHouseId) {
		
		
		List<CarMakeDTO>  cmDTOlist = new ArrayList<>();
		cmDTOlist = mapper.carMakeEntitytoDTOMapper(carmakeRepo.findByWarehouseId(wareHouseId));
		
		return cmDTOlist;
	}

}
