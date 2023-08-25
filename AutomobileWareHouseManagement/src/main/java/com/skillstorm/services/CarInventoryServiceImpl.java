package com.skillstorm.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.DTOs.CarInventoryDTO;
import com.skillstorm.mappers.CarInventoryDTOMapper;
import com.skillstorm.models.CarInventory;
import com.skillstorm.models.CarMake;
import com.skillstorm.repositories.CarInventoryRepository;
import com.skillstorm.repositories.CarMakeRepository;

@Service
public class CarInventoryServiceImpl implements CarInventoryService {

	
	private CarInventoryRepository carInventoryRepository;
	private CarInventoryDTOMapper carInventoryDTOMapper;
	private CarMakeRepository carMakeRepository;
	
	
	@Autowired
	public CarInventoryServiceImpl(CarInventoryRepository carInventoryRepository,
			CarInventoryDTOMapper carInventoryDTOMapper,CarMakeRepository carMakeRepository) {
		super();
		this.carInventoryRepository = carInventoryRepository;
		this.carInventoryDTOMapper = carInventoryDTOMapper;
		this.carMakeRepository = carMakeRepository;
		}



	@Override
	public List<CarInventoryDTO> findCarInventoryBymakeId(int carmakeid) {

		List<CarInventoryDTO>  dtolist = new ArrayList<>();
		dtolist = carInventoryDTOMapper.carInventoryEntitytoDTOMapper(carInventoryRepository.findByCarmakeId(carmakeid));
		return dtolist;
	}



	@Override
	public CarInventory saveCarInventory(CarInventoryDTO cidto) {
		
		

		CarInventory cinv = carInventoryDTOMapper.carInventoryDTOtoEntityMapper(cidto);
		
		CarMake cm = carMakeRepository.findById(cidto.getcarmakeid()).get();
		
		if(cm==null)
		{
			throw new IllegalArgumentException("Carmake not found with id "+cidto.getcarmakeid());
		}
		
		cinv.setCarmake(cm);
		
		cinv = carInventoryRepository.save(cinv);
		
		return cinv;
	}

}
