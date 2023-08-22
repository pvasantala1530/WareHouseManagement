package com.skillstorm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.CarMake;
import com.skillstorm.models.WareHouse;

@Repository
public interface WareHouseRepository extends JpaRepository<WareHouse,Integer> {

	public List<WareHouse> findAll();
}
