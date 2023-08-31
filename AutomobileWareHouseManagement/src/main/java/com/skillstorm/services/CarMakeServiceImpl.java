package com.skillstorm.services;

import java.util.ArrayList;
import java.util.List;

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
	
	@Autowired
	public CarMakeServiceImpl(CarMakeRepository carmakeRepo, CarMakeDTOMapper mapper, WareHouseRepository whrepo) {
		super();
		this.carmakeRepo = carmakeRepo;
		this.mapper = mapper;
		this.whrepo = whrepo;
	}



	@Override
	public List<CarMakeDTO>  findByWareHouseId(int wareHouseId) {
		
		
		List<CarMakeDTO>  cmDTOlist = new ArrayList<>();
		cmDTOlist = mapper.carMakeEntitytoDTOMapper(carmakeRepo.findByWarehouseId(wareHouseId));
		
		return cmDTOlist;
	}
	
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

}
