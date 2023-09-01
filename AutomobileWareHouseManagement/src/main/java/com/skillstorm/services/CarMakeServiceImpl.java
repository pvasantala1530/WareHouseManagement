package com.skillstorm.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.DTOs.CarMakeDTO;
import com.skillstorm.mappers.CarMakeDTOMapper;
import com.skillstorm.models.CarMake;
import com.skillstorm.models.WareHouse;
import com.skillstorm.repositories.CarMakeRepository;
import com.skillstorm.repositories.WareHouseRepository;

@Service
public class CarMakeServiceImpl implements CarMakeService {

	private CarMakeRepository carmakeRepo;
	private CarMakeDTOMapper mapper;
	private WareHouseRepository whrepo;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	public CarMakeServiceImpl(CarMakeRepository carmakeRepo, CarMakeDTOMapper mapper, WareHouseRepository whrepo) {
		super();
		this.carmakeRepo = carmakeRepo;
		this.mapper = mapper;
		this.whrepo = whrepo;
	}


	/* This method calls the car make repository to get all the brands of particular warehouse from the car_make table*/
	@Override
	public List<CarMakeDTO>  findByWareHouseId(int wareHouseId) {
		
		
		List<CarMakeDTO>  cmDTOlist = new ArrayList<>();
		
		cmDTOlist = mapper.carMakeEntitytoDTOMapper(carmakeRepo.findByWarehouseId(wareHouseId));
		
		logger.debug("Carmake dto list: "+cmDTOlist.toString());
		
		return cmDTOlist;
	}
	
	
	/*This method saves the newly added car make to the car_make table */
	@Override
	public void saveNewCarMake(int Warehouseid, String newCarMake) {
		
		
		CarMake cm =new CarMake();
		
		WareHouse wh = whrepo.findById(Warehouseid).get();
		
		if(wh==null)
		{
			throw new IllegalArgumentException("Warehouse not found with id "+Warehouseid);
		}
		
		cm.setWarehouse(wh);
		cm.setMake(newCarMake);
		
		carmakeRepo.save(cm);
		
		return;
	}


	/* This method deletes particular car make from the car_make table*/
	@Override
	public void deleteCarMakeById(int carmakeid) {

		carmakeRepo.deleteById(carmakeid);
		
		return;
		
	}

}
