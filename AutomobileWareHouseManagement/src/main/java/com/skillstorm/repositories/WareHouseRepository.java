package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.WareHouse;

@Repository
public interface WareHouseRepository extends JpaRepository<WareHouse,Integer> {

}
