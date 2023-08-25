package com.skillstorm.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger logger = LoggerFactory.getLogger(getClass());
	
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



	@Override
	public void updateCarInventory(CarInventory ci,String inventoryid, String carmakeid) {
		
		
		CarInventory existingcar = getCarInventory(Integer.valueOf(inventoryid));
		
		existingcar.setColor(ci.getColor());
		existingcar.setModel(ci.getModel());
		existingcar.setQuantity(ci.getQuantity());
		existingcar.setPrice(ci.getPrice());
		existingcar.setId(Integer.valueOf(inventoryid));
		
		CarMake cm = carMakeRepository.findById(Integer.valueOf(carmakeid)).get();
		
		existingcar.setCarmake(cm);
		
		
		
		logger.info("cinv----------"+existingcar.toString());
		
		logger.info("********************cm"+cm.toString());
		
		
		
		
		carInventoryRepository.save(existingcar);
		
		
	}



	@Override
	public CarInventory getCarInventory(int inventoryid) {

		return carInventoryRepository.findById(inventoryid).get();
	}



	@Override
	public void deleteCarInventoryById(int inventoryid) {
		
		
		carInventoryRepository.deleteById(inventoryid);
	}

}
